package com.liferay.sample.module.functional.test.tests;

import static org.junit.Assert.assertEquals;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

public class LiferaySampleCircuitBreakerTest {
		
	@Before
	public void getParameters() throws IOException {
		
		Path currentPath = Paths.get("");
        String filePath = currentPath.toAbsolutePath().toString();
		
        Properties properties = new Properties();
		FileInputStream setupFile = new FileInputStream(filePath.replace(_currentSubFolder, _configFilePath));
		
		properties.load(setupFile);

		attempts = Integer.parseInt(properties.getProperty("minimumNumberOfCallsValue").replaceAll("[^\\d.]", ""));
		
	}
	
	@Test
	public void mustEnterClosedStateWhenMicroserviceFail () {
		
		RestAssured.baseURI = _baseUrl;
		RestAssured.basePath = _basePath;
		
		RequestSpecification httpRequest = RestAssured.given();

		String responseMsg = "";
		
		for (int i = 0; i <= attempts; i++) {
			
			responseMsg = httpRequest.given()
							.header("Accept", _headerAccept)
							.header("Authorization", _headerAuthorization)
							.get("")
							.asString();

		}	
		
		assertEquals(true, Pattern.compile(_resultPattern, Pattern.MULTILINE).matcher(responseMsg).find());
		
	}
		
	private int attempts;
	
	private static final String _resultPattern = "CircuitBreaker|OPEN";
	
	private static final String _baseUrl = "http://localhost:8080";
	
	private static final String _basePath = "o/sample-module/samples";
	
	private static final String _headerAuthorization = "Basic c2FtcGxlLnRlc3RAbGlmZXJheS5jb206dGVzdA==";
	
	private static final String _headerAccept = "application/json";
	
	private static final String _currentSubFolder = "modules/liferay-sample-module/liferay-sample-module-tests";
	
	private static final String _configFilePath = "bundles/osgi/configs/com.liferay.sample.module.ws.config.RestAPIConfiguration.config";
}