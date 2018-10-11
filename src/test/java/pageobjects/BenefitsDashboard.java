package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BenefitsDashboard {

    By usernameLocator = By.cssSelector("input[name^='form-username']");
    By passwordLocator = By.cssSelector("input[name^='form-password']");
    By loginButtonLocator = By.id("btnLogin");
    By benefitsDashboardHeaderLocator = By.xpath("//*[@id='header']/h1[contains(.,'Benefits Dashboard')]");
    By addEmployeeButtonLocator = By.id("btnAddEmployee");
    By addFirstNameLocator = By.xpath("//form[@id='employees-form']/div[1]/*/input");
    By addLastNameLocator = By.xpath("//form[@id='employees-form']/div[2]/*/input");
    By addDependentsLocator = By.xpath("//form[@id='employees-form']/div[3]/*/input");
    By submitNewEmployeeButtonLocator = By.xpath("//button[@type='button' and contains(.,'Submit')]");
    By firstNameValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(2)");
    By lastNameValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(3)");
    By dependendentsValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(5)");
    By benefitCostsLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(7)");
    By netPayLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(8)");


    public WebDriverWait webDriverWait;
    private WebDriver driver;

    /** To run tests locally, please update your path to .../IdeaProject/TestPaylocity/src/test/resources/login.html
     *  or specify url to test environment.
     */
    public BenefitsDashboard(WebDriver driver) {
        this.driver = driver;
        driver.get("file:///C:/Users/Igor/IdeaProject/TestPaylocity/src/test/resources/login.html");
        Assert.assertEquals(driver.findElement(loginButtonLocator).getText(), "Login", "Login page loaded");
    }

    /**
     * Employer login check
     */
    public void pageLogin(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        Assert.assertEquals(driver.findElement(benefitsDashboardHeaderLocator).getText(), "Benefits Dashboard", "Login is successful");
    }

    /**
     * Test logic
     */
    public void addEmployeeNoDiscount(String firstname, String lastname, String dependents) {
        driver.findElement(addEmployeeButtonLocator).click();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitNewEmployeeButtonLocator));
        driver.findElement(addFirstNameLocator).sendKeys(firstname);
        driver.findElement(addLastNameLocator).sendKeys(lastname);
        driver.findElement(addDependentsLocator).sendKeys(dependents);
        driver.findElement(submitNewEmployeeButtonLocator).click();
        Assert.assertEquals(driver.findElement(firstNameValidationLocator).getText(), "Stan", "First name is correct");
        Assert.assertEquals(driver.findElement(lastNameValidationLocator).getText(), "White", "Last name is correct");
        Assert.assertEquals(driver.findElement(dependendentsValidationLocator).getText(), "0", "Number of dependents is correct");
        Assert.assertEquals(driver.findElement(benefitCostsLocator).getText(), "38.46", "Benefit Cost is correct");
        Assert.assertEquals(driver.findElement(netPayLocator).getText(), "1961.54", "Net Pay is correct");
    }
}

