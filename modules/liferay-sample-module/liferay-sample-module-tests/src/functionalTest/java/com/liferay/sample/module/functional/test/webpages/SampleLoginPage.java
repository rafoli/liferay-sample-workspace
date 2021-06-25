package com.liferay.sample.module.functional.test.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SampleLoginPage {
	
	private WebDriver driver;
	
	private static String PAGE_URL = "http://localhost:8080/";
	
	private WebElement heading = driver.findElement(By.id(id));
	
	public SampleLoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
	    PageFactory.initElements(driver, this);		
	}
	
	public boolean isPageOpened(){
       return heading.getText().toString().contains("Developer portal");
   }

}
