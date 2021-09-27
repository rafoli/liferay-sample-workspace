package com.liferay.test.functional.test.tdd.tests;

import com.liferay.test.functional.test.tdd.pages.SampleHomePage;
import com.liferay.test.functional.test.tdd.pages.SampleLoginPage;
import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferaySampleTest {

	@Ignore
	public void checkIfSomeSampleObjectIDisplayed() {
		SampleHomePage sampleHomePage = new SampleHomePage(_driver);

		sampleHomePage.clickOnSignIn();

		SampleLoginPage sampleLoginPage = new SampleLoginPage(_driver);

		sampleLoginPage.fillEmailField("test@liferay.com");
		sampleLoginPage.fillPasswordField("test");

		sampleLoginPage.clickOnSignIn();

		String sampleObjectName = "Sample 1";

		Assert.assertEquals(true, sampleHomePage.isSomeSampleDisplayed(sampleObjectName));
	}

	@Before
	public void setup() {
		
		_driver = _utils.setupAll();
	}

	@Test
	public void signInWithFail() {
		SampleHomePage sampleHomePage = new SampleHomePage(_driver);

		sampleHomePage.clickOnSignIn();

		SampleLoginPage sampleLoginPage = new SampleLoginPage(_driver);

		sampleLoginPage.fillEmailField("abc@liferay.com");
		sampleLoginPage.fillPasswordField("test");

		sampleLoginPage.clickOnSignIn();

		Assert.assertEquals(true, sampleLoginPage.alertErrorIsDisplayed());
	}

	@Test
	public void signInWithSuccess() {
		SampleHomePage sampleHomePage = new SampleHomePage(_driver);

		sampleHomePage.clickOnSignIn();

		SampleLoginPage sampleLoginPage = new SampleLoginPage(_driver);

		sampleLoginPage.fillEmailField("test@liferay.com");
		sampleLoginPage.fillPasswordField("test");

		sampleLoginPage.clickOnSignIn();

		Assert.assertEquals(true, sampleHomePage.isSamplesDisplayed());
	}

	private WebDriver _driver;
	private CommonMethods _utils = new CommonMethods();

}