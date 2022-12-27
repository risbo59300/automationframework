package rca.risbo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rca.risbo.drivers.DriverSingleton;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement zipcode;

    @FindBy(id = "billing_city")
    private WebElement cityName;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span")
    private WebElement totalAmount;

    @FindBy(id = "place_order")
    private WebElement placeOrder;

    @FindBy(css = "#post-207 > header > h1")
    private WebElement orderStatus;

    /**
     *  Verifie que l'adresse est bien saisie
     */
    public void provideBillingDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(address));
        zipcode.sendKeys("8000");
        cityName.sendKeys("Zürich");
        address.sendKeys("abc");
    }

    /**
     * Verifie le montant total de la commande
     * @return
     */
    public String getTotalAmount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return totalAmount.getText();
    }

    /**
     * permet de cliquer sur le bouton place order
     */
    public void placeOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrder);
    }

    public String getOrderStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        return orderStatus.getText();
    }



}
