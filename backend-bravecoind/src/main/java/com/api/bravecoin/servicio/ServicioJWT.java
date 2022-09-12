package com.api.bravecoin.servicio;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.api.bravecoin.config.Configuracion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class ServicioJWT {

	@Autowired
	private Configuracion config;

	public String getJWTToken(String username) {
		String secretKey = config.getSecretkey();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(config.getRol());

		String token = Jwts.builder().setId(config.getId()).setSubject(username)
				.claim(config.getClaim(),
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(config.getExpiracion())))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return config.getType() + token;
	}

}
