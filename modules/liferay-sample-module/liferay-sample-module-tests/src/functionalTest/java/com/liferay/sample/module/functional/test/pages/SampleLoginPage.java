package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleLoginPage {

	public SampleLoginPage(WebDriver driver) {
		_driver = driver;

		PageFactory.initElements(driver, this);
	}

	public boolean alertErrorIsDisplayed() {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_alertError)
		);

		return _alertError.findElement(
			_driver
		).isDisplayed();
	}

	public void clickOnSignIn() {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_signInButton)
		);

		_signInButton.findElement(
			_driver
		).click();
	}

	public void fillEmailField(String email) {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_emailField)
		);

		_emailField.findElement(
			_driver
		).clear();
		_emailField.findElement(
			_driver
		).sendKeys(
			email
		);
	}

	public void fillPasswordField(String password) {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_passwordField)
		);

		_passwordField.findElement(
			_driver
		).clear();
		_passwordField.findElement(
			_driver
		).sendKeys(
			password
		);
	}

	private final By _alertError = By.xpath(
		"//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_loginForm\"]/fieldset/div[2]");
	private String _auxSignButtonXpathPart1 = "/html/body/div[1]/div[1]/div/section/div/div/div/div";
	private String _auxSignButtonXpathPart2 = "/section/div/div[2]/div/div/form/fieldset/div[2]/button/span";
	private WebDriver _driver;
	private final By _emailField = By.xpath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_login\"]");
	private final By _passwordField = By.xpath("//*[@id=\"_com_liferay_login_web_portlet_LoginPortlet_password\"]");
	private String _signButtonXpath = _auxSignButtonXpathPart1 + _auxSignButtonXpathPart2;
	private final By _signInButton = By.xpath(_signButtonXpath.toString());

}