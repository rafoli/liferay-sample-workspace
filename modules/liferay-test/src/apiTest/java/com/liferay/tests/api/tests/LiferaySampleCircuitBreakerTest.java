package com.liferay.tests.api.tests;

import com.liferay.portal.kernel.util.GetterUtil;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andre Batista
 */
public class LiferaySampleCircuitBreakerTest {

	@Before
	public void getParameters() throws IOException {
		Path currentPath = Paths.get("");

		Properties properties = new Properties();

		String toAbsolutPathStr = String.valueOf(currentPath.toAbsolutePath());

		FileInputStream setupFile = new FileInputStream(
			toAbsolutPathStr.replace(_CURRENT_SUBFOLDER, _CONFIG_FILE_PATH));

		properties.load(setupFile);

		String attempts = properties.getProperty(_PROPERTIE_ATTEMPTS);

		String url = properties.getProperty(_PROPERTIE_URL);

		_attempts = GetterUtil.getInteger(attempts.replaceAll("[^\\d.]", ""));

		_baseUrl = _baseUrl.isEmpty() ? url.replaceAll("\"", "") : _baseUrl;
	}

	@Test
	public void mustEnterClosedStateWhenMicroserviceFailUsingGet() {
		RequestSpecification httpRequest = RestAssured.given();

		String responseMsg = "";

		for (int i = 0; i <= _attempts; i++) {
			responseMsg = httpRequest.given(
			).log(
			).all(
			).header(
				"Accept", _HEADER_ACCEPT
			).auth(
			).basic(
				_AUTH_USER, _AUTH_PSW
			).get(
				_baseUrl.concat(_BASE_PATH.isEmpty() ? "" : _BASE_PATH)
			).asString();
		}

		Pattern callResult = Pattern.compile(_RESULT_PATTERN, Pattern.MULTILINE);

		Matcher callResultMatch = callResult.matcher(responseMsg);

		boolean result = callResultMatch.find();

		Assert.assertEquals(true, result);
	}

	private static final String _AUTH_PSW = "test";

	private static final String _AUTH_USER = "test@liferay.com";

	private static final String _BASE_PATH = "";

	private static final String _CONFIG_FILE_PATH =
		"bundles/osgi/configs/com.liferay.sample.module.ws.config.RestAPIConfiguration.config";

	private static final String _CURRENT_SUBFOLDER = "modules/liferay-test";

	private static final String _HEADER_ACCEPT = "application/json";

	private static final String _PROPERTIE_ATTEMPTS = "minimumNumberOfCallsValue";

	private static final String _PROPERTIE_URL = "apiBaseUrl";

	private static final String _RESULT_PATTERN = "CircuitBreaker|OPEN";

	private int _attempts;
	private String _baseUrl = "https://775155f1-2b8e-498e-bcbf-896a98c04e55.mock.pstmn.io/";

}