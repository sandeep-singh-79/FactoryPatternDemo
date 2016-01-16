package com.demo.POM.factory.pages

import com.demo.POM.factory.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage extends BasePageObject {
	@FindBy(css="div#menus")
	List<WebElement> menuBar

	@FindBy(id="nav-questions")
	WebElement questionLink
	
	@FindBy(id="nav-questions")
	List<WebElement> questionsTab

	HomePage(WebDriver driver) {
		super(driver)
	}

	@Override
    protected By getUniqueElement() {
        return By.cssSelector("div#hmenus")
    }

    def clickQuestionsTab() {
        questionLink.click()
        return PageFactory.initElements(this.driver, QuestionsPage.class)
    }

    def isQuestionsTabDisplayed() {
        return questionsTab.size() > 0
    }

}
