package componentsSaceDemoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SauceLabPage {

    private WebDriver driver;
    private String REQUEST_DEMO = "//button[normalize-space()='Request a demo']";
    private String DEMO_TAG = "//h1[contains(text(), 'Request a Demo')]";
    private String EMAIL = "Email";
    private String PROMPT = "(//div[@class='mktoError'])[1]";
    private String COMPANY = "Company";
    private String SOLUTION_ID = "Solution_Interest__c";
    private String SCALABLE_TEST_AUTO = "//option[@value='Scalable Test Automation']";
    private String COMMENT = "Sales_Contact_Comments__c";
    private String INFORMATION_CHECKBOX = "LblmktoCheckbox_46450_0";
    private String SUBMIT = "//button[@type='submit']";

    public SauceLabPage(WebDriver driver) {
        this.driver = driver;
    }
    public SauceLabPage clickOnRequestDemo() {
        WebElement requestDemo = driver.findElement(By.xpath(REQUEST_DEMO));
        requestDemo.click();
        return this;
    }

    public boolean requestDemoTag() {
        try {
            WebElement demoTag = driver.findElement(By.xpath(DEMO_TAG));
            return demoTag.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public SauceLabPage addEmail(String email){
        WebElement emailBox = driver.findElement(By.id(EMAIL));
        emailBox.sendKeys(email);
        emailBox.sendKeys(Keys.TAB);
        emailBox.click();
        return this;
    }

    public boolean mustBeValidPrompt() {
        try {
            WebElement mustBeValidTag = driver.findElement(By.xpath(PROMPT));
            return mustBeValidTag.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public SauceLabPage addCompanyName(String company){
        WebElement companyName = driver.findElement(By.id(COMPANY));
        companyName.sendKeys(company);
        return this;
    }

    public SauceLabPage clickOnInterests(){
        WebElement interest = driver.findElement(By.id(SOLUTION_ID));
        interest.click();
        WebElement firstInterest = driver.findElement(By.xpath(SCALABLE_TEST_AUTO));
        firstInterest.click();
        firstInterest.sendKeys(Keys.TAB);
        return this;
    }

    public SauceLabPage addComment(String comment){
        WebElement commentBox = driver.findElement(By.id(COMMENT));
        commentBox.sendKeys(comment);
        return this;
    }

    public SauceLabPage informationCheckbox(){
        WebElement checkboxInformation = driver.findElement(By.id(INFORMATION_CHECKBOX));
        checkboxInformation.click();
        return this;
    }

    public SauceLabPage submitBox(){
        WebElement submitBox = driver.findElement(By.xpath(SUBMIT));
        return this;
    }
}
