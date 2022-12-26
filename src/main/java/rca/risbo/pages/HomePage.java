package rca.risbo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rca.risbo.drivers.DriverSingleton;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-368 > a")
    private WebElement signInButton;

    @FindBy(id = "menu-item-362")
    private WebElement shopButton;

    @FindBy(css = "#menu-item-371 > a")
    private WebElement username;

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public String getUsername(){
        return username.getText();
    }



}
