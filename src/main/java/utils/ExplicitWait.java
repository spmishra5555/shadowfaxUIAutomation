package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    WebDriverWait webDriverWait = null;

    /**
     * This method is to declare wait based on element visibility
     * @param by
     * @param driver
     * @param timeInSeconds
     */
    public void waitUntilElementIsVisible(By by, WebDriver driver, int timeInSeconds){
        webDriverWait = new WebDriverWait(driver, timeInSeconds);
        WebElement element;
        element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
