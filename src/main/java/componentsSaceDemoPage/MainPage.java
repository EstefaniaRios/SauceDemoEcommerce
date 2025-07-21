package componentsSaceDemoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private String MENU_BURGER = "react-burger-menu-btn";
    private String ABOUT_PAGE = "(//a[normalize-space()='About'])[1]";
    private String BACKPACK = "add-to-cart-sauce-labs-backpack";
    private String SHOPPING_CART = "//a[@class='shopping_cart_link']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage clickOnMenu() {
        WebElement clickOnMenuBurger = driver.findElement(By.id(MENU_BURGER));
        clickOnMenuBurger.click();
        return this;
    }

    public MainPage clickOnAboutPage(){
        WebElement aboutPage = driver.findElement(By.xpath(ABOUT_PAGE));
        aboutPage.click();
        return this;
    }

    public MainPage selectBackPack(){
        WebElement backpack = driver.findElement(By.id(BACKPACK));
        backpack.click();
        return this;
    }

    public MainPage clickOnShoppingCart(){
        WebElement shoppingCart = driver.findElement(By.xpath(SHOPPING_CART));
        shoppingCart.click();
        return this;
    }

}
