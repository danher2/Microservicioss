package com.formacionbdi.springboot.app.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.formacionbdi.springboot.app.oauth.services.IUsuarioService;

@Component
public class AuthenticationSuccesErrorHandler implements AuthenticationEventPublisher{

	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	private Logger log = LoggerFactory.getLogger(AuthenticationSuccesErrorHandler.class);
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails)authentication.getPrincipal();
		String mensaje = "Succes login: " + user.getUsername();
		System.out.println(mensaje);
		log.info(mensaje);
		
		
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		
		String mensaje = "Error en el login: " +  exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);
		
		
	}

	
	
	
}
