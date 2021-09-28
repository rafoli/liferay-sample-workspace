package com.liferay.test.api.tests;

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
	public void getCircuitBreakerConfigureParameters() throws IOException {
		Path currentPath = Paths.get("");

		Properties restApiProperties = new Properties();

		Properties apiProperties = new Properties();

		String toAbsolutPathStr = String.valueOf(currentPath.toAbsolutePath());

		FileInputStream restConfig = new FileInputStream(
			toAbsolutPathStr.replace(_CURRENT_SUBFOLDER, _REST_API_CONFIG));

		FileInputStream apiConfig = new FileInputStream(toAbsolutPathStr.replace(_CURRENT_SUBFOLDER, _API_CONFIG));

		restApiProperties.load(restConfig);

		apiProperties.load(apiConfig);

		String api = apiProperties.getProperty(_PROPERTIES_API);

		api = api.replaceAll("\"", "");

		String attempts = restApiProperties.getProperty(_PROPERTIES_ATTEMPTS);

		String path = apiProperties.getProperty(
			api.equalsIgnoreCase(_API_TYPE) ? _PROPERTIES_JAX_URL : _PROPERTIES_OPENAPI_URL);

		String url = restApiProperties.getProperty(_PROPERTIES_URL);

		_attempts = GetterUtil.getInteger(attempts.replaceAll("[^\\d.]", ""));

		_baseUrl = _baseUrl.isEmpty() ? url.replaceAll("\"", "") : _baseUrl;

		_basePath = path.replaceAll("\"", "");
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
				_baseUrl.concat(
					_basePath
				).concat(
					_API_ENDPOINT
				)
			).asString();
		}

		Pattern callResult = Pattern.compile(_RESULT_PATTERN, Pattern.MULTILINE);

		Matcher callResultMatch = callResult.matcher(responseMsg);

		boolean result = callResultMatch.find();

		Assert.assertEquals(true, result);
	}

	private static final String _API_CONFIG =
		"configs/local/osgi/configs/liferay.openapi.rest.builder.config.LiferayAPIConfiguration.config";

	private static final String _API_ENDPOINT = "/samples";

	private static final String _API_TYPE = "jax";

	private static final String _AUTH_PSW = "test";

	private static final String _AUTH_USER = "test@liferay.com";

	private static final String _CURRENT_SUBFOLDER = "modules/liferay-test";

	private static final String _HEADER_ACCEPT = "application/json";

	private static final String _PROPERTIE_API = "defaultApi";

	private static final String _PROPERTIE_ATTEMPTS = "minimumNumberOfCallsValue";

	private static final String _PROPERTIE_JAX_URL = "apiJaxUrl";

	private static final String _PROPERTIE_OPENAPI_URL = "apiOpenUrl";

	private static final String _PROPERTIE_URL = "apiBaseUrl";

	private static final String _REST_API_CONFIG =
		"bundles/osgi/configs/com.liferay.sample.module.ws.config.RestAPIConfiguration.config";

	private static final String _RESULT_PATTERN = "CircuitBreaker|OPEN";

	private int _attempts;
	private String _basePath;
	private String _baseUrl = "https://4ddd4e2b-8354-46fe-940c-331229556ad1.mock.pstmn.io";

}