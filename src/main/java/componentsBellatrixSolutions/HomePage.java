package componentsBellatrixSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PrivateKey;

public class HomePage {
    private WebDriver driver;
    private String PROMOTIONS = "(//a[normalize-space()='Promotions'])[1]";
    private String CONTACT_FORM = "(//a[normalize-space()='Contact Form'])[1]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickPromotions(){
        WebElement promotions = driver.findElement(By.xpath(PROMOTIONS));
        promotions.click();
        return this;
    }

    public HomePage clickContactForm(){
        WebElement contactForm = driver.findElement(By.xpath(CONTACT_FORM));
        contactForm.click();
        return this;
    }
}
