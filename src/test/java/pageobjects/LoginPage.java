package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageFactoryConstructor {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name^='form-username']")
    private WebElement usernameLocator;

    @FindBy(css = "input[name^='form-password']")
    private WebElement passwordLocator;

    @FindBy(id = "btnLogin")
    private WebElement loginButtonLocator;

}
