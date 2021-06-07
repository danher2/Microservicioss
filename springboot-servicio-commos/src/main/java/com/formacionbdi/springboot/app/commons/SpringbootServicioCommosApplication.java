package com.formacionbdi.springboot.app.commons;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})//para deshabilitar la autoconfiguracion de la satasource porque quite el la dependencia h2
public class SpringbootServicioCommosApplication {

	

}
