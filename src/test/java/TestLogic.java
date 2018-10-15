import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.BenefitsDashboardPage;
import pageobjects.LoginPage;
import pageobjects.PageFactoryConstructor;

public class TestLogic extends PageFactoryConstructor {

    public WebDriverWait webDriverWait;
    public TestLogic(WebDriver driver) {
        super(driver);
    }

    /**
     * Employer login check
     */
    public void userLoginSuccessfully(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(LoginPage.)   .sendKeys(username);
        loginPage.usernameLocator;
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    //ToDo add negative TC
    public void userLoginFail(String username, String password) {
        Assert.assertEquals(driver.findElement(loginPage.loginButtonLocator).getText(), "Login", "Login page loaded");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    /**
     * Test logic
     */
    public void addEmployeeNoDiscount(String firstName, String lastName, String dependents) {
        BenefitsDashboardPage benefitsDashboardPage = new BenefitsDashboardPage(driver);
        //ToDo moved from userLoginSuccessfully
        Assert.assertEquals(driver.findElement(benefitsDashboardHeaderLocator).getText(), "Benefits Dashboard", "Login is successful");
        driver.findElement(addEmployeeButtonLocator).click();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitNewEmployeeButtonLocator));
        driver.findElement(addFirstNameLocator).sendKeys(firstName);
        driver.findElement(addLastNameLocator).sendKeys(lastName);
        driver.findElement(addDependentsLocator).sendKeys(dependents);
        driver.findElement(submitNewEmployeeButtonLocator).click();
        Assert.assertEquals(driver.findElement(firstNameValidationLocator).getText(), "Stan", "First name is correct");
        Assert.assertEquals(driver.findElement(lastNameValidationLocator).getText(), "White", "Last name is correct");
        Assert.assertEquals(driver.findElement(dependentsValidationLocator).getText(), "0", "Number of dependents is correct");
        Assert.assertEquals(driver.findElement(benefitCostsLocator).getText(), "38.46", "Benefit Cost is correct");
        Assert.assertEquals(driver.findElement(netPayLocator).getText(), "1961.54", "Net Pay is correct");
    }

}
