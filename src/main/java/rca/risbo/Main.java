package rca.risbo;

import org.openqa.selenium.WebDriver;
import rca.risbo.drivers.DriverSingleton;
import rca.risbo.pages.*;
import rca.risbo.utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) throws Exception {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        // Initialisation du driverSingleton  les paramètres de framework.properties
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        ShopPage shopPage = new ShopPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        homePage.clickSignIn();
        signInPage.logIn("ybgabamano@gmail.com", "ciara59300");

        if (homePage.getUsername().equals("Hello, yves")) {
            System.out.println("Test to connect Passed");
        } else {
            System.out.println("Test to connect Failed");
        }

        homePage.clickSopButton();

        shopPage.addElementToCart();
        shopPage.proceedToCheckout();
        cartPage.proccedToCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.placeOrder();

        if ( checkoutPage.getOrderStatus().equals("Order received"))
            System.out.println("Test order status passed");
        else
            throw new Exception();


        DriverSingleton.closeObjectInstance();
    }
}