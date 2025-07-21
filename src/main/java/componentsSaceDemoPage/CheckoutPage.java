package componentsSaceDemoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private String CHECKOUT = "checkout";
    private String FIRST_NAME = "first-name";
    private String LAST_NAME = "last-name";
    private String POSTAL_CODE = "postal-code";
    private String CONTINUE = "continue";
    private String POSTAL_CODE_ERROR = "//h3[normalize-space()='Error: Postal Code is required']";

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage clickCheckoutButton(){
        WebElement checkoutButton = driver.findElement(By.id(CHECKOUT));
        checkoutButton.click();
        return this;
    }

    public CheckoutPage addFirstName(String name){
        WebElement addName = driver.findElement(By.id(FIRST_NAME));
        addName.sendKeys(name);
        return this;
    }

    public CheckoutPage addLastName(String lastname){
        WebElement addName = driver.findElement(By.id(LAST_NAME));
        addName.sendKeys(lastname);
        return this;
    }

    public CheckoutPage addZipCode(String zipCode){
        WebElement addName = driver.findElement(By.id(POSTAL_CODE));
        addName.sendKeys(zipCode);
        return this;
    }

    public CheckoutPage clickContinueButton(){
        WebElement continueButton = driver.findElement(By.id(CONTINUE));
        continueButton.click();
        return this;
    }

    public boolean postalCodeRequiredError() {
        try {
            WebElement postalCodeError = driver.findElement(By.xpath(POSTAL_CODE_ERROR));
            return postalCodeError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

