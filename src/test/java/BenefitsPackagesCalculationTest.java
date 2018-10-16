import driver.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BenefitsDashboardPageObject;
import pageobjects.LoginPageObject;

public class BenefitsPackagesCalculationTest extends TestRunner {

    /**
     * This test checks business logic,
     * that employer is able to add new employee without discount
     * and benefit cost calculations are correct.
     */
    @Test
    public void testAddEmployeeNoDiscount() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.withCredentials("testUser", "Test1234");
        Assert.assertEquals(loginPageObject.verifyLogin(), "Benefits Dashboard", "Login is successful");

        BenefitsDashboardPageObject benefitsDashboardPageObject = new BenefitsDashboardPageObject(driver);
        benefitsDashboardPageObject.addEmployeeInformation("Stan", "White", "0");

        Assert.assertEquals(benefitsDashboardPageObject.verifyFirstName(), "Stan", "First name is correct");
        Assert.assertEquals(benefitsDashboardPageObject.verifyLastName(), "White", "Last name is correct");
        Assert.assertEquals(benefitsDashboardPageObject.verifyDependents(), "0", "Number of dependents is correct");
        Assert.assertEquals(benefitsDashboardPageObject.verifyBenefitCosts(), "38.46", "Benefits Costs are correct");
        Assert.assertEquals(benefitsDashboardPageObject.verifyNetPay(), "1961.54", "Net Pay is correct");
    }

//ToDo add negative Login Test
}