package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryConstructor {

    public WebDriver driver;

    public PageFactoryConstructor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
