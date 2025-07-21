package componentsSaceDemoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private String USERNAME = "standard_user";
    private String PASSWORD = "secret_sauce";
    private  String USERNAME_ID = "user-name" ;
    private  String PASSWORD_ID = "password";
    private  String LOGIN_BUTTON = "login-button" ;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage addUsername() {
        WebElement clickFormsPage = driver.findElement(By.id(USERNAME_ID));
        clickFormsPage.sendKeys(USERNAME);
        return this;
    }
    public LoginPage addPassword() {
        WebElement clickFormsPage = driver.findElement(By.id(PASSWORD_ID));
        clickFormsPage.sendKeys(PASSWORD);
        return this;
    }

    public LoginPage clickLogin(){
        WebElement clickLogin = driver.findElement(By.id(LOGIN_BUTTON));
        clickLogin.click();
        return this;
    }
}
