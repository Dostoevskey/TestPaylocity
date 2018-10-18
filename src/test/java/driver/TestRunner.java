package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class TestRunner {

    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setUp() {
        if (threadLocalDriver.get() != null) {
            driver = threadLocalDriver.get();
            webDriverWait = new WebDriverWait(driver, 10);
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String inputFilePath = "src/test/resources/login.html";
        String url = new File(inputFilePath).getAbsolutePath();
        driver.get("file:///" + url);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}

