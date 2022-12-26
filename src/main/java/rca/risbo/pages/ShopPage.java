package rca.risbo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rca.risbo.drivers.DriverSingleton;
import rca.risbo.utils.Constants;

import java.time.Duration;

public class ShopPage {
    WebDriver driver;

    public ShopPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#main > ul > li:nth-child(2) > a.button")
    private WebElement addToCartButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private WebElement numberOfProducts;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement cartButton;

    /**
     * Methode permettant de verifier l'ajout d'un élément dans le panier
     */
    public void addElementToCart(){
        addToCartButton.click();

        if ( numberOfProducts.getText().contains(Constants.CART_QUANTITY) )
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
        }
    }

    /**
     * Permet de vérifier le contenu du panier
     */
    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        cartButton.click();
    }




}
