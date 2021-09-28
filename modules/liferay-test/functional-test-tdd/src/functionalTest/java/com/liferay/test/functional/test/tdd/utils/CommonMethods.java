package com.liferay.test.functional.test.tdd.utils;

<<<<<<< HEAD
<<<<<<< HEAD
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)
=======
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
>>>>>>> d113a58 (INLSW-33 fix: run tests with browser headless mode)
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Andre Batista
 */
public class CommonMethods {

	public void findElementClear(By element, WebDriver driver) {
		WebElement webElement = element.findElement(driver);

		webElement.clear();
	}

	public void findElementClick(WebDriver driver, By element) {
		WebElement webElement = element.findElement(driver);

		webElement.click();
	}

	public boolean findElementContains(By element, WebDriver driver, String name) {
		WebElement webElement = element.findElement(driver);

		String result = String.valueOf(webElement.getText());

		return result.contains(name);
	}

	public boolean findElementIsDisplayed(By element, WebDriver driver) {
		WebElement webElement = element.findElement(driver);

		return webElement.isDisplayed();
	}

	public void findElementSendKeys(WebDriver driver, By element, String name) {
		WebElement webElement = element.findElement(driver);

		webElement.sendKeys(name);
	}

	public void getWaitDriver(WebDriver driver, By element) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		int time_out = SeleniumReadPropertyKeys.getTimeOut();

		WebDriverWait wait = new WebDriverWait(driver, time_out);
=======
		WebDriverWait wait = new WebDriverWait(driver, 30);
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)
=======
		int timeOut = SeleniumReadPropertyKeys.getTimeOut();

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
>>>>>>> d113a58 (INLSW-33 fix: run tests with browser headless mode)
=======
		int time_out = SeleniumReadPropertyKeys.getTimeOut();

		WebDriverWait wait = new WebDriverWait(driver, time_out);
>>>>>>> 76d5f17 (INLSW-33 fix: conflicts)

		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public WebDriver setupAll() throws IOException {
		System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");

		String propertiesPath = SeleniumReadPropertyKeys.getSeleniumPropertyKeysFilePath();

		Properties properties = new Properties();

		FileInputStream config = new FileInputStream(propertiesPath);

		properties.load(config);

		String browserMode = properties.getProperty(_PROPERTIES_BROWSER_MODE);

		config.close();

		ChromeOptions options = new ChromeOptions();

		options.addArguments(browserMode.contentEquals("defaultGCHeadless") ? "--headless" : "--start-maximized");

		return new ChromeDriver(options);
	}

	private static final String _PROPERTIES_BROWSER_MODE = "browser";

=======
>>>>>>> d9c4f18 (INLSW-33 refactor: functional test module into test module)
=======
	public WebDriver setupAll() {
=======
	public WebDriver setupAll() throws IOException {
>>>>>>> 4482eb4 (INLSW-33 fix: formatting, conflicts and update methods)
		System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");

		String propertiesPath = SeleniumReadPropertyKeys.getSeleniumPropertyKeysFilePath();

		Properties properties = new Properties();

		FileInputStream config = new FileInputStream(propertiesPath);

		properties.load(config);

		String browserMode = properties.getProperty(_PROPERTIES_BROWSER_MODE);

		config.close();

		ChromeOptions options = new ChromeOptions();

		options.addArguments(browserMode.contentEquals("defaultGCHeadless") ? "--headless" : "--start-maximized");

		return new ChromeDriver(options);
	}

<<<<<<< HEAD
>>>>>>> d113a58 (INLSW-33 fix: run tests with browser headless mode)
=======
	private static final String _PROPERTIES_BROWSER_MODE = "browser";

>>>>>>> 4482eb4 (INLSW-33 fix: formatting, conflicts and update methods)
}