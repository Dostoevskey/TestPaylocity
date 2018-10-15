package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BenefitsDashboard {

    private WebDriverWait webDriverWait;
    private WebDriver driver;


    final By usernameLocator = By.cssSelector("input[name^='form-username']"); // add for all??
    private By passwordLocator = By.cssSelector("input[name^='form-password']");
    private By loginButtonLocator = By.id("btnLogin");
    private By benefitsDashboardHeaderLocator = By.xpath("//*[@id='header']/h1[contains(.,'Benefits Dashboard')]");
    private By addEmployeeButtonLocator = By.id("btnAddEmployee");
    private By addFirstNameLocator = By.xpath("//form[@id='employees-form']/div[1]/*/input");
    private By addLastNameLocator = By.xpath("//form[@id='employees-form']/div[2]/*/input");
    private By addDependentsLocator = By.xpath("//form[@id='employees-form']/div[3]/*/input");
    private By submitNewEmployeeButtonLocator = By.xpath("//button[@type='button' and contains(.,'Submit')]");
    private By firstNameValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(2)");
    private By lastNameValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(3)");
    private By dependentsValidationLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(5)");
    private By benefitCostsLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(7)");
    private By netPayLocator = By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(8)");

    /**
     * To run tests locally, please update your path to .../IdeaProject/TestPaylocity/src/test/resources/login.html
     * or specify url to test environment.
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
            }

    public void userCantLogin(String username, String password) { // add negative TC
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    /**
     * Test logic
     */
    public void addEmployeeNoDiscount(String firstName, String lastName, String dependents) {
        Assert.assertEquals(driver.findElement(benefitsDashboardHeaderLocator).getText(), "Benefits Dashboard", "Login is successful"); // moved from pageLogin
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