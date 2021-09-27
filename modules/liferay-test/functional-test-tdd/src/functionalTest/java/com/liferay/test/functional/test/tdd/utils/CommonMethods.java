package com.liferay.test.functional.test.tdd.utils;

import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		int timeOut = SeleniumReadPropertyKeys.getTimeOut();

		WebDriverWait wait = new WebDriverWait(driver, timeOut);

		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public WebDriver setupAll() {
		System.setProperty("webdriver.chrome.driver", "SeleniumProperties/chromedriver");
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		return driver;
	}

}