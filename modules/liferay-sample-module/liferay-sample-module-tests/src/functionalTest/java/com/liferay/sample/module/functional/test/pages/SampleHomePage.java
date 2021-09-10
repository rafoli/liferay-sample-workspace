package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleHomePage {

	public SampleHomePage(WebDriver driver) {
		_driver = driver;

		driver.get(_pageUrl);

		PageFactory.initElements(driver, this);
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

	public boolean isSamplesDisplayed() {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_samplesPortlet)
		);

		return _samplesPortlet.findElement(
			_driver
		).isDisplayed();
	}

	public boolean isSomeSampleDisplayed(String name) {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_sampleObject)
		);

		return _sampleObject.findElement(
			_driver
		).getText(
		).toString(
		).contains(
			name
		);
	}

	private static String _pageUrl = "http://localhost:8080/";

	private WebDriver _driver;
	private final By _sampleObject = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/p[2]");
	private final By _samplesPortlet = By.id("js-portlet-_liferaysamplemodulejsweb_");
	private final By _signInButton = By.cssSelector(
		"#_com_liferay_product_navigation_user_personal_bar_web_portlet_" +
			"ProductNavigationUserPersonalBarPortlet_qfkd____ > span");

}