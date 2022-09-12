package com.api.bravecoin.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class DecodeToken {

	public String getUsuarioToken(String jwtToken) {

		String[] split_string = jwtToken.split("\\.");
		String base64EncodedBody = split_string[1];

		Base64 base64Url = new Base64(true);

		String body = new String(base64Url.decode(base64EncodedBody));
		return body;
	}

}
