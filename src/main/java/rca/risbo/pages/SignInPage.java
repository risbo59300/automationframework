package rca.risbo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rca.risbo.drivers.DriverSingleton;

public class SignInPage {
    WebDriver driver;

    public SignInPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="body > div.xoo-el-container.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div.scroll-content > div > div > div.xoo-el-section.xoo-el-active > div > form > div.xoo-aff-group.xoo-el-username_cont > div > input")
    private WebElement signInEmail;

    @FindBy(css = "body > div.xoo-el-container.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div.scroll-content > div > div > div.xoo-el-section.xoo-el-active > div > form > div.xoo-aff-group.xoo-el-password_cont > div > input")
    private WebElement signInPassword;

    @FindBy(css = "body > div.xoo-el-container.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div.scroll-content > div > div > div.xoo-el-section.xoo-el-active > div > form > button")
    private WebElement signInButton;

    public void logIn(String email, String password) {
        signInEmail.sendKeys(email);
        signInPassword.sendKeys(password);
        signInButton.click();
    }


}
