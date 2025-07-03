package tests;
import base.TestBase;
import actions.BrowserActions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.Login;

public class LoginTests extends TestBase {

    String INVENTORY_URL = "https://www.saucedemo.com/v1/inventory.html";

    @Test(dataProvider = "userName", threadPoolSize = 3)
    public void loginWithValidCredentials(String userName) {
        Login loginPage = new Login();
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(userName, "secret_sauce");

        String actualURL = new BrowserActions(BrowserActions.getDriver()).getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL, INVENTORY_URL, "URL doesn't match");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void loginWithEmptyUsername() {
        Login loginPage = new Login();
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("", "anyPassword");

        SoftAssert softAssert = new SoftAssert();
        String actualError = loginPage.getErrorMessageText();
        softAssert.assertEquals(actualError, "Epic sadface: Username is required");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void loginWithInvalidPassword() {
        Login loginPage = new Login();
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("standard_user", "wrong_password");

        SoftAssert softAssert = new SoftAssert();
        String actualError = loginPage.getErrorMessageText();
        softAssert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");
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
