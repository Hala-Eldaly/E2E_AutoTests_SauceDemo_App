package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserActions {
    private WebDriver driver;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void initChromeDriver() {
        driverThreadLocal.set(new EdgeDriver());
    }

    public static void quitChromeDriver() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return new UIActions(driver).isDisplayed(locator);
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
