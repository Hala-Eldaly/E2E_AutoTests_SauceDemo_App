package pom;

import actions.BrowserActions;
import actions.UIActions;

public class Login {
  String loginURL = "https://www.saucedemo.com/v1/";
  String usernameLocator = "id=user-name";
  String passwordLocator = "id=password";
  String loginButtonLocator = "id=login-button";
  String errorMsgLocator = "css=h3[data-test='error']";

  UIActions uiActions;
  BrowserActions bActions;

    public Login() {
        this.uiActions = new UIActions(BrowserActions.getDriver());
        this.bActions = new BrowserActions(BrowserActions.getDriver());
    }

    public void navigateToLoginPage() {
        bActions.navigateTo(loginURL);
    }

    public String getPageURL() {
        return bActions.getPageURL();
    }

    public void loginWithCredentials(String username, String password) {
        uiActions.type(usernameLocator, username);
        uiActions.type(passwordLocator, password);
        uiActions.click(loginButtonLocator);
    }

    public String getErrorMessageText() {
        return uiActions.getText(errorMsgLocator);
    }
}
