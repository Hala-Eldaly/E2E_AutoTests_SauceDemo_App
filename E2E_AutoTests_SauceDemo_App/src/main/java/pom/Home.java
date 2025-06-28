package pom;

import actions.BrowserActions;

public class Home {
    private BrowserActions browserActions;

    public Home(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public String getCurrentPageUrl() {
        return browserActions.getCurrentUrl();
    }

    public boolean pageHasLogo(String logoLocator) {
        return browserActions.isElementDisplayed(logoLocator);
    }
}
