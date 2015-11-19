package com.demo.POM.factory.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.POM.factory.BaseTest;
import com.demo.POM.factory.pages.LandingPage;
import com.demo.POM.factory.pages.QuestionsPage;

public class ExampleTest extends BaseTest{
  
	public ExampleTest() {
        super();
    }

    @Test
    public void clickQuestionsTest() {
        LandingPage landingPage = new LandingPage(driver);
        QuestionsPage questionsPage = landingPage.clickQuestionsTab();
        Assert.assertTrue(questionsPage.isUsersTabDisplayed());
    }

    @Test
    public void isLogoDisplayedTest() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isQuestionsTabDisplayed());
    }
}
