package componentsBellatrixSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PromotionPage {

    private String PROMOTION_COUPON = "(//button[normalize-space()='Do you want 5% off for your BD?'])[1]";
    private WebDriver driver;
    public PromotionPage(WebDriver driver) {
        this.driver = driver;
    }

    public PromotionPage clickPromotionCoupon(){
        WebElement promotionCoupon = driver.findElement(By.xpath(PROMOTION_COUPON));
        promotionCoupon.click();
        driver.switchTo().alert().accept();
        return this;
    }
}
