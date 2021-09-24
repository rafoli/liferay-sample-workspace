package com.liferay.test.functional.test.tdd.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

}