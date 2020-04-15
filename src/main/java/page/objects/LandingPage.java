package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ExplicitWait;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class will store all the methods and its locators for landing page
 */
public class LandingPage {
    private static Properties locators = new Properties();

    static{
        InputStream inputStreamLocators = LoginPage.class.getClassLoader().getResourceAsStream("landingPageLocators.properties");
        try {
            locators.load(inputStreamLocators);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebDriver driver;//driver instance
    ExplicitWait explicitWait;

    By electronicsSectionSelection = By.xpath(locators.getProperty("electronics.section.locators.xpath"));
    By selectOppoPhone = By.linkText(locators.getProperty("selectOppoPhone.locators.linkText"));


    public LandingPage(WebDriver driver){
        this.driver = driver;

    }

    /**
     * This method is to get text for electronics section
     * @return
     */
    public String getTextForElectronicsSection(){
        return driver.findElement(electronicsSectionSelection).getText();
    }

    /**
     * This method is to hover mouse pointer to electronics section
     */
    public void selectElectronicsSection(){
        explicitWait = new ExplicitWait();
        explicitWait.waitUntilElementIsVisible(electronicsSectionSelection, driver, 10);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(electronicsSectionSelection)).click().build().perform();
    }

    /**
     * This method is to select particular mobile phone from list - here its Oppo
     */
    public void selectOppoMobilePhone(){
        explicitWait = new ExplicitWait();
        explicitWait.waitUntilElementIsVisible(selectOppoPhone, driver, 10);

        driver.findElement(selectOppoPhone).click();
    }
}
