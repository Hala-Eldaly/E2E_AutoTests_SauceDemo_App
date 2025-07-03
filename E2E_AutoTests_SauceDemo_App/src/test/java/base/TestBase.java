package base;

import actions.BrowserActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setup() {
        BrowserActions.initChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        BrowserActions.quitChromeDriver();
    }
}
