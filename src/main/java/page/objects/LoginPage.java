package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class will store all the methods and its locators for login page
 */
public class LoginPage {
    private static Properties locators = new Properties();

    static{
        InputStream inputStreamLocators = LoginPage.class.getClassLoader().getResourceAsStream("loginPageLocators.properties");
        try {
            locators.load(inputStreamLocators);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    WebDriver driver;//driver instance

    By username = By.xpath(locators.getProperty("username.locators.xpath"));
    By password = By.xpath(locators.getProperty("password.locators.xpath"));
    By loginButton = By.xpath(locators.getProperty("login.button.locators.xpath"));

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    /**
     * This method is to enter username for login
     * @param userName
     */
    public void enterUserName(String userName){
        driver.findElement(username).sendKeys(userName);
    }

    /**
     * This method is to enter password for login
     * @param passWord
     */
    public void enterPassword(String passWord){
        driver.findElement(password).sendKeys(passWord);
    }

    /**
     * This method is to click on login button
     */
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
}
