package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRunner {

    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    /**
     * To run tests locally, please update your path to .../TestPaylocity/src/test/resources/login.html
     * or specify url to test environment.
     */
    @BeforeTest
    public void setUp() {
        if (threadLocalDriver.get() != null) {
            driver = threadLocalDriver.get();
            webDriverWait = new WebDriverWait(driver, 10);
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Path loginPageFile = Paths.get("src/test/resources/login.html");
        driver.get(loginPageFile.toUri().toString());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}