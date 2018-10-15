package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsDashboardPage extends PageFactoryConstructor {

    public BenefitsDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='header']/h1[contains(.,'Benefits Dashboard')]")
    private WebElement benefitsDashboardHeaderLocator;

    @FindBy(id = "btnAddEmployee")
    private WebElement addEmployeeButtonLocator;

    @FindBy(xpath = "//form[@id='employees-form']/div[1]/*/input")
    private WebElement addFirstNameLocator;

    @FindBy(xpath = "//form[@id='employees-form']/div[2]/*/input")
    private WebElement addLastNameLocator;

    @FindBy(xpath = "//form[@id='employees-form']/div[3]/*/input")
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
}