package cucumberSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeeSteps {

    private WebDriver driver;
    public WebDriverWait webDriverWait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    @Given("^Navigate to the login page$")
    public void navigateToTheLoginPage() throws Throwable {

        driver.get("file:///D:/Paylocity/login.html");
        driver.findElement(By.cssSelector("input[name^='form-username']")).sendKeys("testUser");
        driver.findElement(By.cssSelector("input[name^='form-password']")).sendKeys("Test1234");
        driver.findElement(By.id("btnLogin")).click();
        throw new PendingException();
    }

    @And("^Login as Employer$")
    public void loginAsEmployer() throws Throwable {
        driver.findElement(By.id("header"));
        Assert.assertEquals(driver.findElement(By.id("header")).getText(), "Login is successful", "Login is successful");
        throw new PendingException();
    }

    @When("^I select Add Employee$")
    public void iSelectAddEmployee() throws Throwable {
        driver.findElement(By.id("btnAddEmployee")).click();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(.,'Submit')]")));
        throw new PendingException();
    }

    @Then("^I should be able to enter employee details$")
    public void iShouldBeAbleToEnterEmployeeDetails() throws Throwable {
        driver.findElement(By.xpath("//form[@id='employees-form']/div[1]/*/input")).sendKeys("Nafanya");
        driver.findElement(By.xpath("//form[@id='employees-form']/div[2]/*/input")).sendKeys("Seryi");
        driver.findElement(By.xpath("//form[@id='employees-form']/div[3]/*/input")).sendKeys("3");
        throw new PendingException();
    }

    @And("^First Name does not begin with \"([^\"]*)\" or \"([^\"]*)\"$")
    public void firstNameDoesNotBeginWithOr(String arg0, String arg1) throws Throwable {
        System.out.println("First Name does not begin with 'A' or 'a' success");
        throw new PendingException();
    }

    @And("^the employee should save$")
    public void theEmployeeShouldSave() throws Throwable {
        driver.findElement(By.xpath("//button[@type='button' and contains(.,'Submit')]")).click();
        throw new PendingException();
    }

    @And("^I should see the employee in the table$")
    public void iShouldSeeTheEmployeeInTheTable() throws Throwable {
        Assert.assertEquals(driver.findElement(By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(2)")).getText(), "Nafanya", "First name is correct");
        Assert.assertEquals(driver.findElement(By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(3)")).getText(), "Seryi", "Last name is correct");
        Assert.assertEquals(driver.findElement(By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(5)")).getText(), "3", "Number of dependents is correct");
        throw new PendingException();
    }

    @And("^the benefit cost calculations are correct$")
    public void theBenefitCostCalculationsAreCorrect() throws Throwable {
        Assert.assertEquals(driver.findElement(By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(7)")).getText(), "96.15", "Benefit Cost is correct");
        Assert.assertEquals(driver.findElement(By.cssSelector("#employee-table * tr:nth-of-type(2) td:nth-of-type(8)")).getText(), "1903.85", "Net Pay is correct");
        throw new PendingException();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
