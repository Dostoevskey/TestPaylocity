import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.BenefitsDashboardPage;

public class BenefitsPackagesCalculation {

    private WebDriver driver;
    private BenefitsDashboardPage benefitsDashboardPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        benefitsDashboardPage = new BenefitsDashboardPage(driver);
    }

    /**
     * This test checks business logic,
     * that employer is able to add new employee without discount
     * and benefit cost calculations are correct.
     */
    @Test
    public void addEmployeeNoDiscount() {
        benefitsDashboardPage.pageLogin("testUser", "Test1234");
        benefitsDashboardPage.addEmployeeNoDiscount("Stan", "White", "0");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}