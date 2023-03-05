package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class IssuePageTest extends BaseTest {

    @Test
    public void checkInitValueOfInputSearch() {
        Logger logger = LogManager.getLogger();
        logger.info("The checkInitValueOfInputSearch is started");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("TestForAutomation.777@gmail.com", "Test@777!");
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        String actualResult = issuePage.getValue();
        String expectedResult = "author";
        Assert.assertTrue(actualResult.contains(expectedResult));
        logger.info("The checkInitValueOfInputSearch has passed successfully");
    }

    @Test
    public void checkValueOfInputSearchOnCreatedTab() {
        Logger logger = LogManager.getLogger();
        logger.info("The checkValueOfInputSearchOnCreatedTab is started");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("TestForAutomation.777@gmail.com", "Test@777!");
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        issuePage.clickOnAssignedTab();
        IssuePage updatedAssigned = new IssuePage(driver);
        String expectedResult = "author";
        String actualResultFirst = updatedAssigned.getValue();
        Assert.assertFalse(actualResultFirst.contains(expectedResult));
        updatedAssigned.clickOnCreatedTab();
        IssuePage updateCreated = new IssuePage(driver);
        String actualResultSecond = updateCreated.getValue();
        Assert.assertTrue(actualResultSecond.contains(expectedResult));
        logger.info("The checkValueOfInputSearchOnCreatedTab has passed successfully");
    }

    @Test
    public void checkValueOfInputSearchOnAssignedTab() {
        Logger logger = LogManager.getLogger();
        logger.info("The checkValueOfInputSearchOnAssignedTab is started");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("TestForAutomation.777@gmail.com", "Test@777!");
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        issuePage.clickOnAssignedTab();
        IssuePage updated = new IssuePage(driver);
        String actualResult = updated.getValue();
        String expectedResult = "assignee";
        Assert.assertTrue(actualResult.contains(expectedResult));
        logger.info("The checkValueOfInputSearchOnAssignedTab has passed successfully");
    }

    @Test
    public void checkValueOfInputSearchOnMentionedTab() {
        Logger logger = LogManager.getLogger();
        logger.info("The checkValueOfInputSearchOnMentionedTab is started");
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("TestForAutomation.777@gmail.com", "Test@777!");
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToIssuePage();
        IssuePage issuePage = new IssuePage(driver);
        issuePage.clickOnMentionedTab();
        IssuePage updated = new IssuePage(driver);
        String actualResult = updated.getValue();
        String expectedResult = "mentions";
        Assert.assertTrue(actualResult.contains(expectedResult));
        logger.info("The checkValueOfInputSearchOnMentionedTab has passed successfully");
    }

    @DataProvider(name = "dataProvider1")
    public Object[][] findFieldProvider() {
        return new Object[][]{
                {"Auto"},
                {"test"},
                {"77"},
        };
    }

    @Test(dataProvider = "dataProvider1")
    public void verifyMessage(String data) {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("TestForAutomation.777@gmail.com", "Test@777!");
        MainPage mainPage = new MainPage(driver);
        mainPage.openRepositoryPage();
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.navigateToFindField(data);
        int actual = repositoryPage.getReposList(data);
        Assert.assertTrue(actual == 2);
    }
}
