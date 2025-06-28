package pom;

import actions.UIActions;

public class Login {
    private UIActions actions ;

    private final String usernameLocator = "id=user-name";
    private final String passwordLocator = "id=password";
    private final String loginButtonLocator = "id=login-button";
    private final String errorMsgLocator = "css=h3[data-test='error']";

    public Login(UIActions actions) {
        this.actions = actions; // actions = new UIActions(driver);
    }


    public void loginWithCredentials(String username, String password) {
        actions.type(usernameLocator, username);
        actions.type(passwordLocator, password);
        actions.click(loginButtonLocator);
    }

    public String getErrorMessageText() {
        return actions.getText(errorMsgLocator);
    }
}
