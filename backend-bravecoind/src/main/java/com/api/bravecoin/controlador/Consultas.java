package com.api.bravecoin.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bravecoin.config.Configuracion;
import com.api.bravecoin.data.UsuarioCriptomoneda;
import com.api.bravecoin.dto.JwtDecoderDTO;
import com.api.bravecoin.dto.MonedaDTO;
import com.api.bravecoin.servicio.ServicioConsulta;
import com.api.bravecoin.util.DecodeToken;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Consultas {

	private final String HEADER = "Authorization";

	@Autowired
	private Configuracion config;

	@Autowired
	private DecodeToken decoder;

	@Autowired
	private ServicioConsulta servicio;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/listar_criptomendas")
	public ResponseEntity<List<MonedaDTO>> getCriptomonedas(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(config.getType(), "");

		String jwtDecoder = decoder.getUsuarioToken(jwtToken);
		ObjectMapper om = new ObjectMapper();
		try {
			JwtDecoderDTO root = om.readValue(jwtDecoder, JwtDecoderDTO.class);

			List<UsuarioCriptomoneda> resultado = servicio.getMonedas(root.sub);
			List<MonedaDTO> monedas = new ArrayList<>();
			resultado.forEach(b -> monedas.add(convertToDto(b)));

			return new ResponseEntity<List<MonedaDTO>>(monedas, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MonedaDTO>>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listar_top3")
	public ResponseEntity<List<MonedaDTO>> getTop3(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(config.getType(), "");

		String jwtDecoder = decoder.getUsuarioToken(jwtToken);
		ObjectMapper om = new ObjectMapper();
		try {
			JwtDecoderDTO root = om.readValue(jwtDecoder, JwtDecoderDTO.class);

			List<UsuarioCriptomoneda> resultado = servicio.getMonedasTop3(root.sub);
			List<MonedaDTO> monedas = new ArrayList<>();
			resultado.forEach(b -> monedas.add(convertToDto(b)));

			return new ResponseEntity<List<MonedaDTO>>(monedas, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MonedaDTO>>(HttpStatus.BAD_REQUEST);
		}

	}

	protected MonedaDTO convertToDto(UsuarioCriptomoneda usuarioCripto) {
		MonedaDTO monedaDTO = modelMapper.map(usuarioCripto, MonedaDTO.class);
		return monedaDTO;
	}
}
