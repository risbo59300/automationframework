package rca.risbo.drivers;

import org.openqa.selenium.WebDriver;
import rca.risbo.drivers.strategies.DriverStrategy;
import rca.risbo.drivers.strategies.DriverStrategyImplementer;

import java.time.Duration;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private  DriverSingleton(String driver) {
        instantiate(driver);
    }

    /**
     * Creation d'une instance et maximisation de la fénêtre
     * @param strategy
     * @return
     */
    public WebDriver instantiate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Methode pour instancier une nouvelle instance
     * @return
     */
    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }

        return instance;
    }

    /**
     * Methode pour quitter l'instance
     */

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }

    /**
     * Methode pour retourné un webdriver
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
