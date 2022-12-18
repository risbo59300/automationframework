package rca.risbo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomsJs implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);

        return new PhantomJSDriver(desiredCapabilities);


    }
}
