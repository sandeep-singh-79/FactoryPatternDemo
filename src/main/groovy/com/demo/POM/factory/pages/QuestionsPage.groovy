package com.demo.POM.factory.pages

import com.demo.POM.factory.BasePageObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class QuestionsPage extends BasePageObject {
	@FindBy(css=".youarehere #nav-questions")
	WebElement youAreHere
	
	@FindBy(id="nav-users")
	List<WebElement> usersTab

	QuestionsPage(WebDriver driver) {
		super(driver)
	}

	@Override
    protected By getUniqueElement() {
        return By.cssSelector(".youarehere #nav-questions");
    }

    def isUsersTabDisplayed() {
        return usersTab.size() > 0;
    }

}
