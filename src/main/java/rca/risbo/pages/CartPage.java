package rca.risbo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rca.risbo.drivers.DriverSingleton;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > div > a")
    private WebElement proceedToCheckoutButton;

    /**
     * permet de cliquer sur le bouton proceed to checkout
     */
    public void proccedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));

        proceedToCheckoutButton.click();
    }


}
