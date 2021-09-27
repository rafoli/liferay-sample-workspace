package com.liferay.test.functional.test.tdd.tests;

import com.liferay.test.functional.test.tdd.pages.SampleAngularComponentPage;
import com.liferay.test.functional.test.tdd.pages.SampleHomePage;
import com.liferay.test.functional.test.tdd.pages.SampleLoginPage;
<<<<<<< HEAD
<<<<<<< HEAD
import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import java.io.IOException;
=======
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)
=======
import com.liferay.test.functional.test.tdd.utils.CommonMethods;
>>>>>>> d113a58 (INLSW-33 fix: run tests with browser headless mode)

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.chrome.ChromeDriver;
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)

/**
 * @author Brian Wing Shun Chan
 */
@Ignore
public class LiferaySampleAngularTest {

	@Test
	public void createNewSample() {
		login();

		SampleAngularComponentPage samplePage = new SampleAngularComponentPage(_driver);

		samplePage.createSample("Sample X");

		Assert.assertEquals(true, samplePage.isSampleDisplayed());
	}

	@Test
	public void editSample() {
		login();

		SampleAngularComponentPage samplePage = new SampleAngularComponentPage(_driver);

		samplePage.editSample("Sample W");

		Assert.assertEquals(true, samplePage.isSampleDisplayed());
	}

	public void login() {
		SampleHomePage sampleHomePage = new SampleHomePage(_driver);

		sampleHomePage.clickOnSignIn();

		SampleLoginPage sampleLoginPage = new SampleLoginPage(_driver);

		sampleLoginPage.fillEmailField("test@liferay.com");
		sampleLoginPage.fillPasswordField("test");

		sampleLoginPage.clickOnSignIn();
	}

	@Before
<<<<<<< HEAD
	public void setup() throws IOException {
		_driver = _utils.setupAll();
	}

	private WebDriver _driver;
	private CommonMethods _utils = new CommonMethods();
=======
	public void setup() {
		
		_driver = _utils.setupAll();
	}

	private WebDriver _driver;
<<<<<<< HEAD
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)
=======
	private CommonMethods _utils = new CommonMethods();
>>>>>>> d113a58 (INLSW-33 fix: run tests with browser headless mode)

}