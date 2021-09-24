package com.liferay.test.functional.test.tdd.pages;

import com.liferay.test.functional.test.tdd.utils.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Brian Wing Shun Chan
 */
public class SampleAngularComponentPage {

	public SampleAngularComponentPage(WebDriver driver) {
		_driver = driver;

		driver.get(_PAGE_URL);

		PageFactory.initElements(driver, this);
	}

	public void createSample(String name) {
		_utils.getWaitDriver(_driver, _addButton);

		_utils.findElementClick(_driver, _addButton);

		_utils.findElementSendKeys(_driver, _newNameInput, name);

		_utils.findElementClick(_driver, _newSaveButton);
	}

	public void deleteSample() {
		_utils.getWaitDriver(_driver, _sampleList);

		_utils.findElementClick(_driver, _deleteButton);
	}

	public void editSample(String name) {
		_utils.getWaitDriver(_driver, _sampleList);

		_utils.getWaitDriver(_driver, _firstSample);

		_utils.getWaitDriver(_driver, _editNameInput);

		_utils.findElementClear(_editNameInput, _driver);

		_utils.findElementSendKeys(_driver, _editNameInput, name);

		_utils.findElementClick(_driver, _editSaveButton);
	}

	public boolean isSampleDisplayed() {
		_utils.getWaitDriver(_driver, _sampleList);

		return _utils.findElementIsDisplayed(_sampleList, _driver);
	}

	private static final String _PAGE_URL = "http://localhost:8080/";

	private final By _addButton = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/button");
	private final By _deleteButton = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/button");
	private final WebDriver _driver;
	private final By _editNameInput = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-detail/div/input");
	private final By _editSaveButton = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-detail/div/button");
	private final By _firstSample = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/a");
	private final By _newNameInput = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-create/div/input");
	private final By _newSaveButton = By.xpath(
		"//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-create/div/button[1]");
	private final By _sampleList = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul");
	private CommonMethods _utils = new CommonMethods();

}