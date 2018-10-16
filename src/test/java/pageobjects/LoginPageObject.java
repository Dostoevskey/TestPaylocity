package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageObject {

    /**
     *
     * @param driver
     */
    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name^='form-username']")
    private WebElement usernameLocator;

    @FindBy(css = "input[name^='form-password']")
    private WebElement passwordLocator;

    @FindBy(id = "btnLogin")
    private WebElement loginButtonLocator;

    @FindBy(xpath = "//*[@id='header']/h1[contains(.,'Benefits Dashboard')]")
    private WebElement benefitsDashboardHeaderLocator;

    /**
     *
     * @param username
     * @param password
     */
    public void withCredentials(String username, String password) {
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
    }

    /**
     *
     * @return
     */
    public String verifyLogin() {
        return benefitsDashboardHeaderLocator.getText();
    }
}
