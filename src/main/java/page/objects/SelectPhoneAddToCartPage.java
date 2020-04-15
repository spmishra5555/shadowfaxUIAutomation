package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.ExplicitWait;
import utils.ScreenshotUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * This class will store all the methods and its locators for mobile selection & mobile detail page
 */
public class SelectPhoneAddToCartPage {
    private static Properties locators = new Properties();

        static{
        InputStream inputStreamLocators = LoginPage.class.getClassLoader().
                getResourceAsStream("selectPhoneAddCartPageLocators.properties");
        try {
            locators.load(inputStreamLocators);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebDriver driver;//driver instance
    ExplicitWait explicitWait;

    By clickOnViewAll = By.xpath(locators.getProperty("clickOnViewAll.locators.xpath"));
    By selectPhone = By.xpath(locators.getProperty("selectPhone.locators.xpath"));
    By selectMobileName = By.xpath(locators.getProperty("selectMobileName.locators.xpath"));


    public SelectPhoneAddToCartPage(WebDriver driver){
        this.driver = driver;

    }

    /**
     * This method is to click on view all option
     */
    public void clickOnViewAll(){
        explicitWait = new ExplicitWait();
        explicitWait.waitUntilElementIsVisible(clickOnViewAll, driver, 15);

        driver.findElement(clickOnViewAll).click();

    }

    /**
     * This method is to select mobile here - OPPO mobile.
     */
    public void selectPhone(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //JavascriptExecutor to scroll down the page where data is present
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, 1150)");
        explicitWait = new ExplicitWait();
        explicitWait.waitUntilElementIsVisible(selectPhone, driver, 10);

        driver.findElement(selectPhone).click();

    }

    /**
     * This method is to switch the tab for adding the item into cart
     */
    public void switchTabThenAddToCartPage(){

        String windowHandle = driver.getWindowHandle();
        List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        ScreenshotUtils.screenshot(driver);//Taking screenshot of the current page using screenshot Util
    }

    /**
     * This method is to get the text of selected mobile phone
     * @return
     */
    public String getSelectedMobileName(){
        explicitWait = new ExplicitWait();
        explicitWait.waitUntilElementIsVisible(selectMobileName, driver, 10);
        return driver.findElement(selectMobileName).getText();
    }
}
