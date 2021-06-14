package com.formacionbdi.springboot.app.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.formacionbdi.springboot.app.oauth.services.IUsuarioService;

import brave.Tracer;
import feign.FeignException;

@Component
public class AuthenticationSuccesErrorHandler implements AuthenticationEventPublisher {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private Tracer tracer;

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccesErrorHandler.class);

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		
		if (authentication.getName().equalsIgnoreCase("frontendapp")) {
			return; // si es igual a frontendapp se salen del método!
		}
		
		
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Succes login: " + user.getUsername();
		System.out.println(mensaje);
		log.info(mensaje);

		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		
		if (usuario.getIntentos() != null && usuario.getIntentos() > 0) {
			usuario.setIntentos(0);
			usuarioService.update(usuario, usuario.getId());
		}

	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {

		String mensaje = "Error en el login: " + exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);

		try {
			
			StringBuilder errors = new StringBuilder();
			errors.append(mensaje);
			
			Usuario usuario = usuarioService.findByUsername(authentication.getName());
			if (usuario.getIntentos() == null) {
				usuario.setIntentos(0);
			}

			log.info("Intentos actuales  de: " + usuario.getIntentos());
			
			usuario.setIntentos(usuario.getIntentos() + 1);
			
			log.info("Intentos despues  de: " + usuario.getIntentos());
			
			errors.append("  - Intentos del login: " + usuario.getIntentos());
			
			if (usuario.getIntentos() >= 3) {
				
				String errorMaxIntentos = String.format("El usuario %s des-habilitado por 3 intentos ", usuario.getUsername());
				log.error(errorMaxIntentos);
				errors.append(" - " + errorMaxIntentos);
				usuario.setEnabled(false);
			}

			usuarioService.update(usuario, usuario.getId());
			tracer.currentSpan().tag("error.mensaje", errors.toString());
			
		} catch (FeignException e) {
			log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));

		}

	}

}
