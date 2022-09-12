package com.api.bravecoin.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario_criptomoneda")
public class UsuarioCriptomoneda {

	@SequenceGenerator(name = "idUsuarioCriptomoneda", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_USUARIO_CRIPTOMONEDA")
	@GeneratedValue(generator = "idUsuarioCriptomoneda", strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	private Double precio;
	private String nombre;
	private Long rankingCapitalizaion;

}
