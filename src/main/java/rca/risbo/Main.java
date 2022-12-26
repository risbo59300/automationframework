package rca.risbo;

import org.openqa.selenium.WebDriver;
import rca.risbo.drivers.DriverSingleton;
import rca.risbo.pages.HomePage;
import rca.risbo.pages.SignInPage;
import rca.risbo.utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        // Initialisation du driverSingleton  les paramètres de framework.properties
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();

        homePage.clickSignIn();
        signInPage.logIn("ybgabamano@gmail.com", "ciara59300");

        if (homePage.getUsername().equals("Hello, yves")) {
            System.out.println("Test  Passed");
        } else {
            System.out.println("Test Failed");
        }

        DriverSingleton.closeObjectInstance();
    }
}