package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageObject {

    /**
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

    @FindBy(xpath = "//*[@id='validation-errors' and contains(.,'The password is incorrect for username testUser')]")
    private WebElement incorrectPassword;

    @FindBy(tagName = "h1")
    private WebElement benefitsDashboardHeader;

    /**
     * @param username
     * @param password
     */
    public void withCredentials(String username, String password) {
        credentialsUsername.clear();
        credentialsUsername.sendKeys(username);
        credentialsPassword.clear();
        credentialsPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * @return
     */
    public boolean verifyLoginSuccess() {
        return benefitsDashboardHeader.isDisplayed();
    }

    /**
     * @return
     */
    public String verifyLoginFailed() {
        return incorrectPassword.getText();
    }
}
