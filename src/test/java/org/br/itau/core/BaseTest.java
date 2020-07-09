package org.br.itau.core;


import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseTest {

    protected RemoteWebDriver driver;

    protected RemoteWebDriver startTestCase() {
        DriverSelenium driverSelenium = new DriverSelenium();
        driver = driverSelenium.getDriver();
        return driver;
    }

    public void finishTestCase() {
        DriverSelenium driverSelenium = new DriverSelenium();
        driverSelenium.closeDriver();
    }
}
