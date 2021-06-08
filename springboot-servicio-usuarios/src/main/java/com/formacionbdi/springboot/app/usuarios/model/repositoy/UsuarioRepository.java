package com.formacionbdi.springboot.app.usuarios.model.repositoy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;


@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

		public Usuario findByUsername(String username);  //revisar Query Methods
		
		
		//query method mediante anotacion query
		@Query("select u from Usuario u where u.username=?1")
		public Usuario obtenerPorUsername(String username);
	
	
	
}
