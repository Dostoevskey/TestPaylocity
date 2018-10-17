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
        Assert.assertEquals(loginPageObject.verifyLogin(), "Benefits Dashboard", "Login is unsuccessful");

        BenefitsDashboardPageObject benefitsDashboardPageObject = new BenefitsDashboardPageObject(driver);
        benefitsDashboardPageObject.addEmployeeInformation("Stan", "White", "0");

        Assert.assertEquals(benefitsDashboardPageObject.verifyFirstName(), "Stan", "First name is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyLastName(), "White", "Last name is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyDependents(), "0", "Number of dependents is incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyBenefitCosts(), "38.46", "Benefits Costs are incorrect");
        Assert.assertEquals(benefitsDashboardPageObject.verifyNetPay(), "1961.54", "Net Pay is incorrect");
    }

//ToDo add negative Login Test
}