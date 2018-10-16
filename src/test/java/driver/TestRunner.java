package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
        driver.get("file:///C:/Users/Igor/IdeaProject/TestPaylocity/src/test/resources/login.html");  //ToDo add method to read files from resources
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}

