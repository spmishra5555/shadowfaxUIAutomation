package in.shadowfax.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    /**
     * This method is to get the driver's instance
     * @return
     */
    public WebDriver getDriverInstance(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
