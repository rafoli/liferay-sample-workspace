package com.liferay.test.functional.test.tdd.tests;

import com.liferay.test.functional.test.tdd.pages.SampleAngularComponentPage;
import com.liferay.test.functional.test.tdd.pages.SampleHomePage;
import com.liferay.test.functional.test.tdd.pages.SampleLoginPage;

import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.WebDriver;



/**
 * @author Brian Wing Shun Chan
 */
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
	public void setup() throws IOException {
		_driver = _utils.setupAll();
	}

	private WebDriver _driver;
	private CommonMethods _utils = new CommonMethods();

}