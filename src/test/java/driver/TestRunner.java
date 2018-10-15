package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestRunner {

    public WebDriver driver;

    /**
     * To run tests locally, please update your path to .../TestPaylocity/src/test/resources/login.html
     * or specify url to test environment.
     */
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Igor/IdeaProject/TestPaylocity/src/test/resources/login.html");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
