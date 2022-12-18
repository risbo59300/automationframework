package rca.risbo;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private  DriverSingleton() {
        instantiate("Chrome");
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
    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
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
