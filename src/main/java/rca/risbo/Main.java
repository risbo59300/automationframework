package rca.risbo;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        // Initialisation du driverSingleton  les paramètres de framework.properties
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");
    }
}