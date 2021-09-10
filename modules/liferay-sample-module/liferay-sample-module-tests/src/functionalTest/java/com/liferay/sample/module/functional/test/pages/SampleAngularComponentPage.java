package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_addButton)
		);

		_addButton.findElement(
			_driver
		).click();

		_newNameInput.findElement(
			_driver
		).sendKeys(
			name
		);

		_newSaveButton.findElement(
			_driver
		).click();
	}

	public void deleteSample() {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_sampleList)
		);
		_deleteButton.findElement(
			_driver
		).click();
	}

	public void editSample(String name) {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_sampleList)
		);

		_firstSample.findElement(
			_driver
		).click();

		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_editNameInput)
		);

		_editNameInput.findElement(
			_driver
		).clear();
		_editNameInput.findElement(
			_driver
		).sendKeys(
			name
		);
		_editSaveButton.findElement(
			_driver
		).click();
	}

	public boolean isSampleDisplayed() {
		SeleniumWaitMethods.getWaitDriver(
			_driver
		).until(
			ExpectedConditions.visibilityOfElementLocated(_sampleList)
		);

		return _sampleList.findElement(
			_driver
		).isDisplayed();
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

}