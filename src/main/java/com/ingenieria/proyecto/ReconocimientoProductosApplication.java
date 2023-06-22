package com.ingenieria.proyecto;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReconocimientoProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReconocimientoProductosApplication.class, args);
	}

	@Bean
	public OpenAPI info(){
		return new OpenAPI()
				.info(new Info()
						.title("Documentacion de API para proyecto de Ingenieria de Software")
						.description("BACKEND DEVs")
						.contact(new Contact()
								.email("prodas@facultad.sanfrancisco.utn.edu.ar"))
						.version("v1"));
	}
}
