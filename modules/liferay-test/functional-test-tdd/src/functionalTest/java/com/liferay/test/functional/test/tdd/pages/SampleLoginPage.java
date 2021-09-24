package com.liferay.test.functional.test.tdd.pages;

import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleLoginPage {

	public SampleLoginPage(WebDriver driver) {
		_driver = driver;

		PageFactory.initElements(driver, this);
	}

	public boolean alertErrorIsDisplayed() {
		_utils.getWaitDriver(_driver, _alertError);

		return _utils.findElementIsDisplayed(_alertError, _driver);
	}

	public void clickOnSignIn() {
		_utils.getWaitDriver(_driver, _signInButton);

		_utils.findElementClick(_driver, _signInButton);
	}

	public void fillEmailField(String email) {
		_utils.getWaitDriver(_driver, _emailField);

		_utils.findElementClear(_emailField, _driver);

		_utils.findElementSendKeys(_driver, _emailField, email);
	}

	public void fillPasswordField(String password) {
		_utils.getWaitDriver(_driver, _passwordField);

		_utils.findElementClear(_passwordField, _driver);

		_utils.findElementSendKeys(_driver, _passwordField, password);
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
	private CommonMethods _utils = new CommonMethods();

}