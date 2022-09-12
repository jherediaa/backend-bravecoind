package com.api.bravecoin.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bravecoin.data.Usuario;
import com.api.bravecoin.repositorio.RepositorioUsuario;

@Service
public class ServicioLogin {

	@Autowired
	private RepositorioUsuario repositorio;

	public Usuario login(String usuario, String contrasenia) {

		List<Usuario> resultado = repositorio.getUsuario(usuario, contrasenia);

		return resultado.isEmpty() ? null : resultado.get(0);
	}

}
