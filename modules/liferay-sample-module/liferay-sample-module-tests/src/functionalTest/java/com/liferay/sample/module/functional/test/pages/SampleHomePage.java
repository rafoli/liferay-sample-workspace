package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SampleHomePage {

	private WebDriver driver;

	private static String PAGE_URL = "http://localhost:8080/";

	private final By signInButton = By.cssSelector("#_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_qfkd____ > span");

	private final By samples = By.id("js-portlet-_liferaysamplemodulejsweb_");
	
	public SampleHomePage(WebDriver driver) {
		this.driver = driver;
		
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	public void clickOnSignIn() {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		signInButton.findElement(driver).click();
	}
	
	public boolean isSamplesDisplayed() {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(samples));
		return samples.findElement(driver).isDisplayed();
	}

}
