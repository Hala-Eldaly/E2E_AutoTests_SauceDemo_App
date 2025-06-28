package tests;

import base.TestBase;
import actions.BrowserActions;
import actions.UIActions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.Login;

public class LoginTests extends TestBase {

    @Test(dataProvider = "userName", threadPoolSize = 3)
    public void loginWithValidCredentials(String userName) {
        UIActions actions = new UIActions(getDriver());
        BrowserActions browserActions = new BrowserActions(getDriver());
        Login loginPage = new Login(actions);

        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials(userName, "secret_sauce");

        String actualUrl = browserActions.getCurrentUrl();
        softAssert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html", "URL doesn't match");

        softAssert.assertAll();
    }

    @Test
    public void loginWithInvalidPassword() {
        UIActions actions = new UIActions(getDriver());
        Login loginPage = new Login(actions);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("standard_user", "wrong_password");

        String actualError = loginPage.getErrorMessageText();
        softAssert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");

        softAssert.assertAll();
    }

    @Test
    public void loginWithEmptyUsername() {
        UIActions actions = new UIActions(getDriver());
        Login loginPage = new Login(actions);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("", "anyPassword");

        String actualError = loginPage.getErrorMessageText();
        softAssert.assertEquals(actualError, "Epic sadface: Username is required");

        softAssert.assertAll();
    }

    @DataProvider(name = "userName", parallel = true)
    public Object[] getUserNames() {
        return new Object[]{
                "standard_user",
                "problem_user",
                "performance_glitch_user"
        };
    }
}
