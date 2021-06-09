package com.formacionbdi.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

@FeignClient(name="servicio-usuarios") //nomobre del microservicio con el cual nos queremos comunicar
public interface UsuarioFeignClient {
	
	//metodo para definir el endpoint al que vamos a ir a buscar al usuario por el username
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
	

}
