package com.liferay.sample.module.functional.test.tests;

import static org.junit.Assert.assertEquals;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.Test;

public class LiferaySampleCircuitBreakerTest {

	@Test
	public void mustEnterClosedStateWhenMicroserviceFail () {
		
		RestAssured.baseURI = "http://localhost:8080"; //_restAPIConfiguration.apiBaseUrl();
		RestAssured.basePath = "o/sample-module/samples";
		
		RequestSpecification httpRequest = RestAssured.given();

		String responseMsg = "";
		
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
