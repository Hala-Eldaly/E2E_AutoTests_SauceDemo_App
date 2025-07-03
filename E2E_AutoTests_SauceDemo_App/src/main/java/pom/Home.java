package pom;

import actions.BrowserActions;
import actions.UIActions;

public class Home {
    String productPageURL = "https://www.saucedemo.com/v1/inventory.html";
    UIActions uiActions;
    BrowserActions bActions;

    public Home() {
        this.uiActions = new UIActions(BrowserActions.getDriver());
        this.bActions = new BrowserActions(BrowserActions.getDriver());
    }

    public void navigateToProductsPage() {
        bActions.navigateTo(productPageURL);
    }

    public String getHomePageURL() {
        return bActions.getPageURL();
    }

    public String getCurrentPageUrl() {
        return bActions.getCurrentUrl();
    }

    public boolean pageHasLogo(String logoLocator) {
        return bActions.isElementDisplayed(logoLocator);
    }
}
