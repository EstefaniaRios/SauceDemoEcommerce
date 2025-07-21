package componentsSaceDemoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutOverviewPage {
    private WebDriver driver;
    String TOTALPRICEID = "//div[@class='summary_total_label']";
    String FINISHBUTTONID = "finish";
    String COMPLETEDTAGID = "//img[@alt='Pony Express']";


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean totalPriceIsDisplayed() {
        try {
            WebElement totalPrice = driver.findElement(By.xpath(TOTALPRICEID));
            return totalPrice.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CheckoutOverviewPage clickFinish(){
        WebElement finishButton = driver.findElement(By.id(FINISHBUTTONID));
        finishButton.click();
        return this;
    }

    public boolean completedTag(String FILE_ROUTE) {
        try {
            WebElement compeletedTag = driver.findElement(By.xpath(COMPLETEDTAGID));
            return compeletedTag.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

