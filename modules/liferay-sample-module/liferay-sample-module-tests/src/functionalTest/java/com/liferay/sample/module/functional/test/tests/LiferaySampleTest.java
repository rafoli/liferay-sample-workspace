package com.liferay.sample.module.functional.test.tests;

import static org.junit.Assert.assertEquals;
import com.liferay.sample.module.functional.test.pages.SampleHomePage;
import com.liferay.sample.module.functional.test.pages.SampleLoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiferaySampleTest {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");
		
		driver = new ChromeDriver();
	}

	@Test
	public void signInWithSuccess() {
		
		SampleHomePage sampleHomePage = new SampleHomePage(driver);
		
		sampleHomePage.clickOnSignIn();
		
		SampleLoginPage sampleLoginPage = new SampleLoginPage(driver);
		
		sampleLoginPage.fillEmailField("test@liferay.com");
		sampleLoginPage.fillPasswordField("test");
		
		sampleLoginPage.clickOnSignIn();
				
		assertEquals(true, sampleHomePage.isSamplesDisplayed());	

	}
	
	@Test
	public void signInWithFail() {
		SampleHomePage sampleHomePage = new SampleHomePage(driver);
		
		sampleHomePage.clickOnSignIn();
		
		SampleLoginPage sampleLoginPage = new SampleLoginPage(driver);
		
		sampleLoginPage.fillEmailField("abc@liferay.com");
		sampleLoginPage.fillPasswordField("test");
		
		sampleLoginPage.clickOnSignIn();
		
		assertEquals(true, sampleLoginPage.alertErrorIsDisplayed());
	}

}
