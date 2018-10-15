import driver.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BenefitsPackagesCalculation extends TestRunner {

    /**
     * This test checks business logic,
     * that employer is able to add new employee without discount
     * and benefit cost calculations are correct.
     */
    @Test
    public void addEmployeeNoDiscount() throws InterruptedException {
        TestLogic testLogic = new TestLogic(driver);
        testLogic.userLoginSuccessfully("testUser", "Test1234");
        testLogic.addEmployeeNoDiscount("Stan", "White", "0");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}