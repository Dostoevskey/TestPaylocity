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
    private WebElement addEmployeeButton;

    @FindBy(css = "#employees-form div:nth-of-type(1) input")
    private WebElement addFirstName;

    @FindBy(css = "#employees-form div:nth-of-type(2) input")
    private WebElement addLastName;

    @FindBy(css = "#employees-form div:nth-of-type(3) input")
    private WebElement addDependents;

    @FindBy(xpath = "//button[@type='button' and contains(.,'Submit')]")
    private WebElement submitNewEmployeeButton;

    @FindBy(css = "#employee-table tr:nth-of-type(2) td:nth-of-type(2)")
    private WebElement firstNameValidation;

    @FindBy(css = "#employee-table tr:nth-of-type(2) td:nth-of-type(3)")
    private WebElement lastNameValidation;

    @FindBy(css = "#employee-table tr:nth-of-type(2) td:nth-of-type(5)")
    private WebElement dependentsValidation;

    @FindBy(css = "#employee-table tr:nth-of-type(2) td:nth-of-type(7)")
    private WebElement benefitCosts;

    @FindBy(css = "#employee-table tr:nth-of-type(2) td:nth-of-type(8)")
    private WebElement netPay;

    /**
     *
     * @param firstName
     * @param lastName
     * @param dependents
     */
    public void addEmployeeInformation(String firstName, String lastName, String dependents) {
        addEmployeeButton.click();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitNewEmployeeButton));
        addFirstName.sendKeys(firstName);
        addLastName.sendKeys(lastName);
        addDependents.sendKeys(dependents);
        submitNewEmployeeButton.click();
    }

    /**
     *
     * @return
     */
    public String verifyFirstName() {
        return firstNameValidation.getText();
    }

    /**
     *
     * @return
     */
    public String verifyLastName() {
        return lastNameValidation.getText();
    }

    /**
     *
     * @return
     */
    public String verifyDependents() {
        return dependentsValidation.getText();
    }

    /**
     *
     * @return
     */
    public String verifyBenefitCosts() {
        return benefitCosts.getText();
    }

    /**
     *
     * @return
     */
    public String verifyNetPay() {
        return netPay.getText();
    }
}