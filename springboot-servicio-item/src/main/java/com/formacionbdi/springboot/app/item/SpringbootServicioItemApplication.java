package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})//para deshabilitar la autoconfiguracion de la satasource porque quite el la dependencia h2
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
