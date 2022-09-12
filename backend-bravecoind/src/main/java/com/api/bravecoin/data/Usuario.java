package com.api.bravecoin.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	private String nombre;
	private String apellido;
	@Id
	private String username;
	private String contrasenia;
	private MonedaLocal moneda;
	private String tasa;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
	private List<UsuarioCriptomoneda> listaMonedas;

}
