package com.liferay.sample.module.functional.test.tests;

import com.liferay.sample.module.functional.test.pages.SampleAngularComponentPage;
import static org.junit.Assert.assertEquals;

import com.liferay.sample.module.functional.test.pages.SampleHomePage;
import com.liferay.sample.module.functional.test.pages.SampleLoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiferaySampleAngularTest {
    WebDriver driver;

    @Before
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");

        driver = new ChromeDriver();
    }

    public void login () {
        SampleHomePage sampleHomePage = new SampleHomePage(driver);

        sampleHomePage.clickOnSignIn();

        SampleLoginPage sampleLoginPage = new SampleLoginPage(driver);

        sampleLoginPage.fillEmailField("test@liferay.com");
        sampleLoginPage.fillPasswordField("test");

        sampleLoginPage.clickOnSignIn();
    }

    @Test
    public void createNewSample () {
        login();
        SampleAngularComponentPage samplePage = new SampleAngularComponentPage(driver);
        samplePage.createSample("Sample X");
        assertEquals(true, samplePage.isSampleDisplayed());
    }

    @Test
    public void editSample () {
        login();
        SampleAngularComponentPage samplePage = new SampleAngularComponentPage(driver);
        samplePage.editSample("Sample W");
        assertEquals(true, samplePage.isSampleDisplayed());
    }
}
