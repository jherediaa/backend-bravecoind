package com.api.bravecoin.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.bravecoin.data.Usuario;
import com.api.bravecoin.dto.RequestLoginDTO;
import com.api.bravecoin.dto.ResponseLoginDTO;
import com.api.bravecoin.servicio.ServicioJWT;
import com.api.bravecoin.servicio.ServicioLogin;

@RestController
public class Login {

	@Autowired
	private ServicioJWT servicioJWT;

	@Autowired
	private ServicioLogin servicioLogin;

	@PostMapping("/login")
	public ResponseEntity<ResponseLoginDTO> login(@RequestBody @Validated RequestLoginDTO loginDto) {

		Usuario usuario = servicioLogin.login(loginDto.getUsuario(), loginDto.getContrasenia());

		if (usuario == null)
			return new ResponseEntity<ResponseLoginDTO>(
					new ResponseLoginDTO(null, null, "Usuario/Constrasenia inválida"), HttpStatus.BAD_REQUEST);

		String token = servicioJWT.getJWTToken(loginDto.getUsuario());
		return new ResponseEntity<ResponseLoginDTO>(new ResponseLoginDTO(loginDto.getUsuario(), token, HttpStatus.ACCEPTED.toString()),
				HttpStatus.OK);

	}

}
