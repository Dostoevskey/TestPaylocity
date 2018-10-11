package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsContainer {

    public WebDriver driver;

    LocatorsContainer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[name^='form-username']")
    private WebElement usernameLocator;

    @FindBy(css = "input[name^='form-password']")
    private WebElement passwordLocator;

    @FindBy(id = "btnLogin")
    private WebElement loginButtonLocator;



    //By loginButtonLocator = By.id("btnLogin");
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


}
