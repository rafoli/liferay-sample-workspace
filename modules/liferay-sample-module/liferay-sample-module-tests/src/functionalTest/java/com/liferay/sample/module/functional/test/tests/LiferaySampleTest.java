package com.liferay.sample.module.functional.test.tests;

import com.liferay.sample.module.functional.test.pages.SampleHomePage;
import com.liferay.sample.module.functional.test.pages.SampleLoginPage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferaySampleTest {

	@Test
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
		System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");

		_driver = new ChromeDriver();
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

}