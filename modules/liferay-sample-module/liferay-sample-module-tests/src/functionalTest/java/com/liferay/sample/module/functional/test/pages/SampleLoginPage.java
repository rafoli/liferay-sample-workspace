package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SampleLoginPage {
	
	private WebDriver driver;

	private final By emailField = By.xpath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_login\"]");
	
	private final By passwordField = By.xpath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_password\"]");

	private final By signInButton = By.xpath("/html/body/div[1]/div[1]/div/section/div/div/div/div/section/div/div[2]/div/div/form/fieldset/div[2]/button/span");

	private final By alertError = By.xpath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/div[2]");
	
	public SampleLoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void fillEmailField(String email) {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(emailField));

		emailField.findElement(driver).clear();
		emailField.findElement(driver).sendKeys(email);
	}
	
	public void fillPasswordField(String password) {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(passwordField));

		passwordField.findElement(driver).clear();
		passwordField.findElement(driver).sendKeys(password);
	}
	
	public void clickOnSignIn() {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		
		signInButton.findElement(driver).click();
	}
	
	public boolean alertErrorIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(alertError));
		
		return alertError.findElement(driver).isDisplayed();
	}
	
}
