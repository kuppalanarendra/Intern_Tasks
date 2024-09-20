package com.example.AdharService.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdharConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
