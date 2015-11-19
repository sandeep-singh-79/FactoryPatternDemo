package com.demo.POM.factory.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.POM.factory.BasePageObject;

public class QuestionsPage extends BasePageObject {
	@FindBy(css=".youarehere #nav-questions")
	WebElement youAreHere;
	
	@FindBy(id="nav-users")
	List<WebElement> usersTab;

	public QuestionsPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(this.driver, this);
	}

	@Override
    protected By getUniqueElement() {
        return By.cssSelector(".youarehere #nav-questions");
    }

    public Boolean isUsersTabDisplayed() {
        return usersTab.size() > 0;
    }

}
