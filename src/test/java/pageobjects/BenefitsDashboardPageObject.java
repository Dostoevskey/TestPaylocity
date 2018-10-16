package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitsDashboardPageObject extends PageObject {

    WebDriverWait webDriverWait;

    /**
     *
     * @param driver
     */
    public BenefitsDashboardPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btnAddEmployee")
    private WebElement addEmployeeButtonLocator;

    @FindBy(css = "form[id='employees-form'] div:nth-child(1) input")
    private WebElement addFirstNameLocator;

    @FindBy(xpath = "//form[@id='employees-form']/div[2]/*/input") //ToDo find new css locator
    private WebElement addLastNameLocator;

    @FindBy(xpath = "//form[@id='employees-form']/div[3]/*/input") //ToDo find new css locator
    private WebElement addDependentsLocator;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Submit')]")
    private WebElement submitNewEmployeeButtonLocator;

    @FindBy(css = "#employee-table * tr:nth-of-type(2) td:nth-of-type(2)")
    private WebElement firstNameValidationLocator;

    @FindBy(css = "#employee-table * tr:nth-of-type(2) td:nth-of-type(3)")
    private WebElement lastNameValidationLocator;

    @FindBy(css = "#employee-table * tr:nth-of-type(2) td:nth-of-type(5)")
    private WebElement dependentsValidationLocator;

    @FindBy(css = "#employee-table * tr:nth-of-type(2) td:nth-of-type(7)")
    private WebElement benefitCostsLocator;

    @FindBy(css = "#employee-table * tr:nth-of-type(2) td:nth-of-type(8)")
    private WebElement netPayLocator;

    /**
     *
     * @param firstName
     * @param lastName
     * @param dependents
     */
    public void addEmployeeInformation(String firstName, String lastName, String dependents) {
        addEmployeeButtonLocator.click();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitNewEmployeeButtonLocator));
        addFirstNameLocator.sendKeys(firstName);
        addLastNameLocator.sendKeys(lastName);
        addDependentsLocator.sendKeys(dependents);
        submitNewEmployeeButtonLocator.click();
    }

    /**
     *
     * @return
     */
    public String verifyFirstName() {
        return firstNameValidationLocator.getText();
    }

    /**
     *
     * @return
     */
    public String verifyLastName() {
        return lastNameValidationLocator.getText();
    }

    /**
     *
     * @return
     */
    public String verifyDependents() {
        return dependentsValidationLocator.getText();
    }

    /**
     *
     * @return
     */
    public String verifyBenefitCosts() {
        return benefitCostsLocator.getText();
    }

    /**
     *
     * @return
     */
    public String verifyNetPay() {
        return netPayLocator.getText();
    }
}