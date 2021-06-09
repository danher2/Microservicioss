package com.formacionbdi.springboot.app.commons.usuarios;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) //excluir autoconfiguracion de spring dat jpa
public class SpringbootServicioUsuariosCommonsApplication {



}
