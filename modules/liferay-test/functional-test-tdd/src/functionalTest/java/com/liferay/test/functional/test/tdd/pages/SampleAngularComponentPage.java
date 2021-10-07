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

	public boolean isSampleTextDisplayed(String text) {
		WebDriver.Navigation url = _driver.navigate();

		url.refresh();

		String pageSource = _driver.getPageSource();

		return pageSource.contains(text);
	}

	private static final String _PAGE_URL = "http://localhost:8080/";

	private static final String _PREFIX = "//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]";

	private final By _addButton = By.xpath(_PREFIX.concat("/div/div/app-sample-list/button"));
	private final By _deleteButton = By.xpath(
		_PREFIX.concat("/div/div/app-sample-list/div/table/tbody/tr[1]/td[3]/div/button"));
	private final WebDriver _driver;
	private final By _editNameInput = By.xpath(_PREFIX.concat("/app-sample-detail/div/input"));
	private final By _editSaveButton = By.xpath(_PREFIX.concat("/app-sample-detail/div/button"));
	private final By _firstSample = By.xpath(_PREFIX.concat("/app-sample-list/ul/li[1]/a"));
	private final By _newNameInput = By.xpath(_PREFIX.concat("/div/div/app-sample-create/div/div/div[1]/input"));
	private final By _newSaveButton = By.xpath(_PREFIX.concat("/div/div/app-sample-create/div/div/div[2]/button"));
	private final By _sampleList = By.xpath(_PREFIX.concat("/div/div/app-sample-list/div/table/tbody"));
	private CommonMethods _utils = new CommonMethods();

}