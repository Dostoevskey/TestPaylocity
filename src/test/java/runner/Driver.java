package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumberSteps.AddEmployeeSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BenefitsDashboard;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "cucumberSteps",
        tags = "@all",
        snippets = SnippetType.CAMELCASE
)

public class Driver {

    private WebDriver driver;
    private AddEmployeeSteps addEmployeeSteps;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        addEmployeeSteps = new AddEmployeeSteps(driver);
    }

    /**
     * This test checks business logic,
     * that employer is able to add new employee without discount
     * and benefit cost calculations are correct.
     */
    @Test
    public void addEmployeeNoDiscount() {
        benefitsDashboard.pageLogin("testUser", "Test1234");
        benefitsDashboard.addEmployeeNoDiscount("Stan", "White", "0");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}

