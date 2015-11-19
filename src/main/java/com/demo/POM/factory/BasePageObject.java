package com.demo.POM.factory;

import groovy.util.ConfigObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePageObject {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	private ConfigObject config = FrameworkConfig.getConfig();

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,
				(Long)config.get("WEBDRIVERWAIT_TIMEOUT"),
				(Long) config.get("WEBDRIVERWAIT_POLL"));
		
		isLoaded();
	}
	
	/**
	 * Each page object must implement this method to return the identifier of a unique WebElement on that page.
	 * The presence of this unique element will be used to assert that the expected page has finished loading
	 * @return the By locator of unique element on the page
	 */
	protected abstract By getUniqueElement();
	
	protected void isLoaded() throws Error{
		//Define a list of WebElements that match the unique element locator for the page
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());

        // Assert that the unique element is present in the DOM
        Assert.assertTrue((uniqueElement.size() > 0),
                "Unique Element \'" + getUniqueElement().toString() + "\' not found for " + this.getClass().getSimpleName());

        // Wait until the unique element is visible in the browser and ready to use. This helps make sure the page is
        // loaded before the next step of the tests continue.
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
	}

}
