package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new EdgeDriver(); // ممكن تبدليها بـ ChromeDriver برحتك
        driverThreadLocal.set(driver);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // إضافي
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driverThreadLocal.remove();
    }
}
