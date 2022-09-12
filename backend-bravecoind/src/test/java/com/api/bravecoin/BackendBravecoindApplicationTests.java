package com.api.bravecoin;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.with;

import io.restassured.RestAssured;

@SpringBootTest
class BackendBravecoindApplicationTests {

	@Before(value = "init")
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9996;
	}

	@Test
	public void login() {
		with().body("{ " + "    \"usuario\" : \"jheredia\",\n" + "    \"contrasenia\" : \"judith\"\n" + "}").when()
				.request("POST", "/login").then().statusCode(200);
	}

}
