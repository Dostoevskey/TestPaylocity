import driver.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BenefitsDashboardPageObject;
import pageobjects.LoginPageObject;

public class BenefitsPackagesCalculationTest extends TestRunner {

    /**
     * This test verifies that user cannot login with incorrect password.
     */
    @Test
    public void testLoginFailedFalsePositive() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.withCredentials("testUser", "Password");
        Assert.assertEquals(loginPageObject.verifyLoginFailed(), "The password is incorrect for username testUser");
    }

    /**
     * This test checks business logic,
     * that employer is able to add new employee without discount
     * and benefit cost calculations are correct.
     */
    @Test
    public void testPaylocityAddEmployeeNoDiscount() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.withCredentials("testUser", "Test1234");
        loginPageObject.verifyLoginSuccess();

        BenefitsDashboardPageObject benefitsDashboardPageObject = new BenefitsDashboardPageObject(driver);
        benefitsDashboardPageObject.addEmployeeInformation("Stan", "White", "0");

        Assert.assertEquals(benefitsDashboardPageObject.verifyFirstName(), "Stan", "First name is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyLastName(), "White", "Last name is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyDependents(), "0", "Number of dependents is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyBenefitCosts(), "38.46", "Benefits Costs are incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyNetPay(), "1961.54", "Net Pay is incorrect");
    }
}