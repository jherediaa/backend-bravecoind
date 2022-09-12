package com.api.bravecoin.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bravecoin.data.UsuarioCriptomoneda;

@Service
public class ServicioConsulta {

	@Autowired
	private com.api.bravecoin.repositorio.RepositorioUsuarioCriptomoneda repositorio;

	public List<UsuarioCriptomoneda> getMonedas(String usuario) {
		return repositorio.getMonedas(usuario);
	}

	public List<UsuarioCriptomoneda> getMonedasTop3(String usuario) {
		return repositorio.getMonedasTop3(usuario);
	}
}
