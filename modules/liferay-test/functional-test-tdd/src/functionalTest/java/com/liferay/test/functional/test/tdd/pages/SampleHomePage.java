package com.liferay.test.functional.test.tdd.pages;

import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		_utils.getWaitDriver(_driver, _signInButton);

		_utils.findElementClick(_driver, _signInButton);
	}

	public boolean isSamplesDisplayed() {
		_utils.getWaitDriver(_driver, _samplesPortlet);

		return _utils.findElementIsDisplayed(_samplesPortlet, _driver);
	}

	public boolean isSomeSampleDisplayed(String name) {
		_utils.getWaitDriver(_driver, _sampleObject);

		return _utils.findElementContains(_sampleObject, _driver, name);
	}

	private static String _pageUrl = "http://localhost:8080/";

	private WebDriver _driver;
	private final By _sampleObject = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/p[2]");
	private final By _samplesPortlet = By.id("js-portlet-_liferaysamplemodulejsweb_");
	private final By _signInButton = By.cssSelector(
		"#_com_liferay_product_navigation_user_personal_bar_web_portlet_" +
			"ProductNavigationUserPersonalBarPortlet_qfkd____ > span");
	private CommonMethods _utils = new CommonMethods();

}