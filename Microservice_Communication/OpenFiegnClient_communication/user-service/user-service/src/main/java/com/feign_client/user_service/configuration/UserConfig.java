package com.feign_client.user_service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
	@Bean
	public ModelMapper getModelMapperObject() {
		return new ModelMapper();
	}

}
