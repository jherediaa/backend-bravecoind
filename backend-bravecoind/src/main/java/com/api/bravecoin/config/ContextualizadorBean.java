package com.api.bravecoin.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 @Configuration
public class ContextualizadorBean {

	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
