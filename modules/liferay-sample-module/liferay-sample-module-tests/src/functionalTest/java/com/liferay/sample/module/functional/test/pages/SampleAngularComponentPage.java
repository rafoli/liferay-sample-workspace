package com.liferay.sample.module.functional.test.pages;

import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SampleAngularComponentPage {
    private final WebDriver driver;
    private final static String PAGE_URL = "http://localhost:8080/";

    private final By sampleList = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul");

    private final By addButton = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/button");
    private final By deleteButton = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/button");

    private final By firstSample = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-list/ul/li[1]/a");

    private final By newNameInput = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-create/div/input");
    private final By newSaveButton = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-create/div/button[1]");

    private final By editNameInput = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-detail/div/input");
    private final By editSaveButton = By.xpath("//*[@id=\"js-portlet-_liferaysamplemodulejsweb_\"]/app-sample-detail/div/button");


    public SampleAngularComponentPage (WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void editSample (String name) {
        SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(sampleList));

        firstSample.findElement(driver).click();

        SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(editNameInput));

        editNameInput.findElement(driver).clear();
        editNameInput.findElement(driver).sendKeys(name);
        editSaveButton.findElement(driver).click();
    }

    public void createSample (String name) {
        SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(addButton));

        addButton.findElement(driver).click();

        newNameInput.findElement(driver).sendKeys(name);

        newSaveButton.findElement(driver).click();

    }

    public void deleteSample () {
        SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(sampleList));
        deleteButton.findElement(driver).click();
    }

    public boolean isSampleDisplayed () {
        SeleniumWaitMethods.getWaitDriver(driver).until(ExpectedConditions.visibilityOfElementLocated(sampleList));
        return sampleList.findElement(driver).isDisplayed();
    }
}
