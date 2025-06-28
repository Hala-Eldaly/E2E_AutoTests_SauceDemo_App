package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIActions {
    private WebDriver driver;

    public UIActions(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(String locator) {
        String[] parts = locator.split("=", 2);
        String type = parts[0];
        String value = parts[1];

        switch (type) {
            case "id":
                return driver.findElement(By.id(value));
            case "css":
                return driver.findElement(By.cssSelector(value));
            case "xpath":
                return driver.findElement(By.xpath(value));
            default:
                throw new RuntimeException("Unsupported locator type: " + type);
        }
    }

    public void type(String locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(String locator) {
        findElement(locator).click();
    }

    public String getText(String locator) {
        return findElement(locator).getText();
    }

    public boolean isDisplayed(String locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
