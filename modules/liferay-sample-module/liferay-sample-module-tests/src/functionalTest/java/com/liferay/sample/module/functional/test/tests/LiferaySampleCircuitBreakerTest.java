package com.liferay.sample.module.functional.test.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

import com.liferay.portal.kernel.util.GetterUtil;

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
 * @author Brian Wing Shun Chan
 */
public class LiferaySampleCircuitBreakerTest {

	@Before
	public void getHost() {

		//By default REST assured assumes host: http://localhost and port: 8080 when doing a request.
		//If it is necessary to use a different URL, the _BASE_URL variable can be populated.

		if (!_BASE_URL.isEmpty()) {
			RestAssured.baseURI = _BASE_URL;
		}

		RestAssured.basePath = _BASE_PATH;
	}

	@Before
	public void getParameters() throws IOException {
		Path currentPath = Paths.get("");

		Properties properties = new Properties();

		FileInputStream setupFile = new FileInputStream(
			currentPath.toAbsolutePath(
			).toString(
			).replace(
				_CURRENT_SUBFOLDER, _CONFIG_FILE_PATH
			));

		properties.load(setupFile);

		String attempts = properties.getProperty(_PROPERTIE);

		_attempts = GetterUtil.getInteger(attempts.replaceAll("[^\\d.]", ""));
	}

	@Test
	public void mustEnterClosedStateWhenMicroserviceFailUsingGet() {
		RequestSpecification httpRequest = RestAssured.given();

		String responseMsg = "";

		for (int i = 0; i <= _attempts; i++) {
			responseMsg = httpRequest.given(
			).header(
				"Accept", _HEADER_ACCEPT
			).header(
				"Authorization", _HEADER_AUTHORIZATION
			).get(
				""
			).asString();
		}

		Pattern callResult = Pattern.compile(_RESULT_PATTERN, Pattern.MULTILINE);

		Matcher callResultMatch = callResult.matcher(responseMsg);

		boolean result = callResultMatch.find();

		Assert.assertEquals(true, result);
	}

	private static final String _BASE_PATH = "o/sample-module/samples";

	private static final String _BASE_URL = "";

	private static final String _CONFIG_FILE_PATH =
		"bundles/osgi/configs/com.liferay.sample.module.ws.config.RestAPIConfiguration.config";

	private static final String _CURRENT_SUBFOLDER = "modules/liferay-sample-module/liferay-sample-module-tests";

	private static final String _HEADER_ACCEPT = "application/json";

	private static final String _HEADER_AUTHORIZATION = "Basic c2FtcGxlLnRlc3RAbGlmZXJheS5jb206dGVzdA==";

	private static final String _PROPERTIE = "minimumNumberOfCallsValue";

	private static final String _RESULT_PATTERN = "CircuitBreaker|OPEN";

	private int _attempts;

}