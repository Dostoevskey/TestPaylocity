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
    private WebElement credentialsUsername;

    @FindBy(css = "input[name^='form-password']")
    private WebElement credentialsPassword;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='header']/h1[contains(.,'Benefits Dashboard')]")
    private WebElement benefitsDashboardHeader;

    /**
     *
     * @param username
     * @param password
     */
    public void withCredentials(String username, String password) {
        credentialsUsername.sendKeys(username);
        credentialsPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     *
     * @return
     */
    public String verifyLogin() {
        return benefitsDashboardHeader.getText();
    }
}
