package com.ingenieria.proyecto;

import com.ingenieria.proyecto.util.GenericConstant;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan("com.ingenieria.proyecto")
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

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping(GenericConstant.RESOURCE_GENERIC + "/**")
						.allowedOrigins("http://front.simix.tech", "http://localhost:3000")
						.allowedMethods("*")
						.allowedHeaders("*", "Authorization")
						.exposedHeaders("Authorization");
			}
		};
	}
}
