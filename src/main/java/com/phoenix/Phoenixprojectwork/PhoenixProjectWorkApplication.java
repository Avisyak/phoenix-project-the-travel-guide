package com.phoenix.Phoenixprojectwork;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class PhoenixProjectWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoenixProjectWorkApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
