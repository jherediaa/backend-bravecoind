package com.api.bravecoin.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonedaDTO {

	private Double precio;
	private String nombre;
	private Long rankingCapitalizaion;

}
