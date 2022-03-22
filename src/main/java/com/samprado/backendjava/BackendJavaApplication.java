package com.samprado.backendjava;

import com.samprado.backendjava.entity.Personagem;
import com.samprado.backendjava.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendJavaApplication{

	public static void main(String[] args) {
		SpringApplication.run(BackendJavaApplication.class, args);
	}


	

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("http://localhost:3000")
			;}


		};
	}
}
