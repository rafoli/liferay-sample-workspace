package com.liferay.sample.module.functional.test.tests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import com.jayway.restassured.*;
import com.jayway.restassured.specification.RequestSpecification;
import com.liferay.sample.module.ws.config.RestAPIConfiguration;

public class LiferaySampleCircuitBreakerTest {

	RestAPIConfiguration restAPIConfiguration;

	@Test
	public void mustEnterClosedStateWhenMicroserviceFail () {
		RestAssured.baseURI = "http://localhost:8080/";
		RestAssured.basePath = "o/sample-module/samples";
		
		String responseMsg = "";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		for (int i = 0; i < 4; i++) {
			responseMsg = httpRequest.given()
							.header("Accept", "application/json")
							.header("Authorization", "Basic c2FtcGxlLnRlc3RAbGlmZXJheS5jb206dGVzdA==")
							.get("")
							.asString();
		}	
		
		assertEquals(true, responseMsg.contains("CircuitBreaker"));
		
	}
	
}
