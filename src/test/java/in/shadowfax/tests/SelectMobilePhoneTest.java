package in.shadowfax.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.SelectPhoneAddToCartPage;
import utils.ScreenshotUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SelectMobilePhoneTest extends BaseTest{
    private static Properties forInputValues = new Properties();

    static {
        InputStream inputStreamData = LoginPage.class.getClassLoader().getResourceAsStream("inputData.properties");
        try {
            forInputValues.load(inputStreamData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "This test is to select the required mobile phone and take the screenshot of the final step")
    public void selectMobilePhoneTest() throws InterruptedException {

        WebDriver driver = getDriverInstance();

        driver.get(forInputValues.getProperty("url"));

     try {
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterUserName(forInputValues.getProperty("mobile.number"));
         loginPage.enterPassword(forInputValues.getProperty("password"));
         loginPage.clickOnLoginButton();

         LandingPage landingPage = new LandingPage(driver);

         Assert.assertEquals(landingPage.getTextForElectronicsSection(), forInputValues.getProperty("electronics"));

         landingPage.selectElectronicsSection();
         landingPage.selectOppoMobilePhone();

         SelectPhoneAddToCartPage selectPhoneAddToCartPage = new SelectPhoneAddToCartPage(driver);

         selectPhoneAddToCartPage.clickOnViewAll();
         selectPhoneAddToCartPage.selectPhone();
         selectPhoneAddToCartPage.switchTabThenAddToCartPage();

         Assert.assertTrue(selectPhoneAddToCartPage.getSelectedMobileName().contains(forInputValues.
                 getProperty("mobile.name")));

         ScreenshotUtils.screenshot(driver);

     }catch (Exception e){
         e.getStackTrace();
     }
    }
}
