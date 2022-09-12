package com.api.bravecoin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class Configuracion {

	@Value("${aplicacion.token.expiracion}")
	private String expiracion;
	@Value("${aplicacion.token.secretkey}")
	private String secretkey;
	@Value("${aplicacion.token.id}")
	private String id;
	@Value("${aplicacion.seguridad.rol}")
	private String rol;
	@Value("${aplicacion.token.type}")
	private String type;
	@Value("${aplicacion.seguridad.claim}")
	private String claim;

	
}
