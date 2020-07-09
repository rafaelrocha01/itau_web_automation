package org.br.itau.core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;
import static org.br.itau.config.Parametro.IMPLICITWAIT;
import static org.br.itau.config.Parametro.URL;


public class DriverSelenium {

    private RemoteWebDriver driver;

    private void setGoogleChrome() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITWAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    protected RemoteWebDriver getDriver() {
        setGoogleChrome();
        return driver;
    }

    protected void closeDriver(){
        driver.close();
        driver.quit();
    }
}
