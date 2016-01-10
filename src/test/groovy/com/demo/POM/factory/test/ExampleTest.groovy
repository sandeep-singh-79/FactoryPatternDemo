package com.demo.POM.factory.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.POM.factory.BaseTest;
import com.demo.POM.factory.pages.HomePage;
import com.demo.POM.factory.pages.QuestionsPage;

class ExampleTest extends BaseTest{
  
	ExampleTest() {
        super();
    }

    @Test
    void clickQuestionsTest() {
        HomePage homePage = PageFactory.initElements(this.driver, HomePage.class)
        QuestionsPage questionsPage = homePage.clickQuestionsTab()
        Assert.assertTrue((boolean)questionsPage.isUsersTabDisplayed())
    }

    @Test
    void isLogoDisplayedTest() {
        HomePage homePage = PageFactory.initElements(this.driver, HomePage.class)
        Assert.assertTrue(homePage.isQuestionsTabDisplayed())
    }
}
