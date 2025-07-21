import componentsBellatrixSolutions.ContactForm;
import componentsBellatrixSolutions.HomePage;
import componentsBellatrixSolutions.PromotionPage;
import componentsSaceDemoPage.BasePage;
import org.junit.Before;
import org.junit.After;;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class bellatrixSolutionTestCases extends BasePage {
    WebDriverWait wait;
    public String NAME = "Erick";
    public String LAST_NAME = "Thompson";
    public String EMAIL = "erickThompson@email.com";
    public String WINDOWS_SCROLL = "window.scrollBy(0, 900)";

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
        driver.get("https://demos.bellatrix.solutions/");
    }

    @Test
    public void PromptTestCase() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickPromotions();
        PromotionPage promotionPage = new PromotionPage(driver);
        promotionPage.clickPromotionCoupon();
        Thread.sleep(2000);
        }

        @Test
        public void fillContactForm() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickContactForm();
        ContactForm contactForm = new ContactForm(driver);
        contactForm.addName(NAME).addLastname(LAST_NAME).addEmail(EMAIL);
        JavascriptExecutor windowScroll = (JavascriptExecutor)driver;
        windowScroll.executeScript(WINDOWS_SCROLL);
        contactForm.clickSubmit();
        Thread.sleep(3000);
        Assert.assertTrue(contactForm.accessPassError());
        Assert.assertTrue(contactForm.sessionError());
        Assert.assertTrue(contactForm.overnightError());
        }

    @After
    public void setUpAfter(){
        driver.quit();
    }
}
