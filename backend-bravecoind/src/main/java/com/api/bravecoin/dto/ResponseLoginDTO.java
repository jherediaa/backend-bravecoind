package com.api.bravecoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseLoginDTO {

	private String username;
	private String token;
	private String mensaje;
	
	

}
