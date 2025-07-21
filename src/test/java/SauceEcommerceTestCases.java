import componentsSaceDemoPage.*;
import componentsSaceDemoPage.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;


public class SauceEcommerceTestCases extends BasePage {

    WebDriverWait wait;
    String INVALID_EMAIL = "123email.com";
    String VALID_EMAIL = "123@gmail.com";
    String COMPANY = "Company test";
    String COMMENT = "This is a comment";
    String NAME = "Name test";
    String LAST_NAME = "Last test";
    String ZIP_CODE = "4322";
    double randomNumber = Math.random();
    String FILE_ROUTE = "c:\\\\tmp\\\\screenshotOrderCompleted" + randomNumber + ".png";



    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test //("Go to Request Demo Page from About Page")
    public void goToRequestDemoPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addUsername().addPassword().clickLogin();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnMenu();
        Thread.sleep(2000);
        mainPage.clickOnAboutPage();
        SauceLabPage sauceLabPage = new SauceLabPage(driver);
        sauceLabPage.clickOnRequestDemo();
        Thread.sleep(2000);
        Assert.assertEquals(sauceLabPage.requestDemoTag(), true);
        sauceLabPage.addEmail(INVALID_EMAIL);
        Assert.assertEquals(sauceLabPage.mustBeValidPrompt(),true);
        sauceLabPage.addCompanyName(COMPANY);
        sauceLabPage.addComment(COMMENT);
        sauceLabPage.informationCheckbox().submitBox();
        Assert.assertEquals(sauceLabPage.mustBeValidPrompt(),true);
    }

    @Test //(Checkout cannot be done without zip code)
    public void checkoutCannotBeCompleted() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addUsername().addPassword().clickLogin();
        MainPage mainPage = new MainPage(driver);
        mainPage.selectBackPack();
        mainPage.clickOnShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
        Thread.sleep(3000);
        checkoutPage.addFirstName(NAME).addLastName(LAST_NAME);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.postalCodeRequiredError(), true);
    }

    @Test //(Complete Checkout.)
    public void completeCheckoutFlow() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addUsername().addPassword().clickLogin();
        MainPage mainPage = new MainPage(driver);
        mainPage.selectBackPack();
        mainPage.clickOnShoppingCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
        Thread.sleep(3000);
        checkoutPage.addFirstName(NAME).addLastName(LAST_NAME).addZipCode(ZIP_CODE);
        checkoutPage.clickContinueButton();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(FILE_ROUTE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    checkoutOverviewPage.clickFinish();
        Assert.assertEquals(checkoutOverviewPage.completedTag(FILE_ROUTE), true);

        if(!checkoutOverviewPage.completedTag(FILE_ROUTE)){
            System.out.println("Not complete");
        }else {
            System.out.println("Complete");
        }
    }

     @After
     public void setUpAfter(){
         driver.quit();
     }
}


