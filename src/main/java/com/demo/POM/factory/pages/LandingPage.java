package com.demo.POM.factory.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.POM.factory.BasePageObject;

public class LandingPage extends BasePageObject {
	@FindBy(css="div#menus")
	List<WebElement> menuBar;
	
	@FindBy(id="nav-questions")
	WebElement questionLink;
	
	@FindBy(id="nav-questions")
	List<WebElement> questionsTab;

	public LandingPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(this.driver, this);
	}

	@Override
    protected By getUniqueElement() {
        return By.cssSelector("div#hmenus");
    }

    By menuBarLocator = By.cssSelector("div#hmenus");
    By questionsTabLocator = By.id("nav-questions");

    public QuestionsPage clickQuestionsTab() {
        questionLink.click();
        return new QuestionsPage(driver);
    }

    public Boolean isQuestionsTabDisplayed() {
        return questionsTab.size() > 0;
    }

}
