package com.liferay.sample.module.functional.test.tests;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.liferay.gs.testFramework.FunctionalTest;

public class GoogleTest extends FunctionalTest {

	@Test
	public void goToGooglePageAndSearch() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		File file = new File(classLoader.getResource("geckodriver").getFile());
		
		System.setProperty("webdriver.gecko.driver", file.getPath());

		WebDriver driver = new FirefoxDriver();
      
		try {
            driver.get("https://google.com/ncr");
            driver.findElement(By.name("q")).sendKeys("seleniumhq" + Keys.ENTER);
        } finally {
            driver.quit();
        }		
	}
}
