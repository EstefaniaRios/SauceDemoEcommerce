package componentsBellatrixSolutions;

import componentsSaceDemoPage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactForm extends BasePage {

    public ContactForm(WebDriver driver) {
        this.driver = driver;
    }

    public String NAME_ID = "wpforms-3347-field_1";
    public String LASTNAME_ID = "wpforms-3347-field_1-last";
    public String EMAIL_ID = "wpforms-3347-field_2";
    public String SUBMIT = "wpforms-submit-3347";
    public String ACCESS_ERROR = "wpforms[fields][3]-error";
    public  String SESSION_ERROR = "wpforms[fields][4][]-error";
    public String OVERNIGHT_ERROR = "wpforms[fields][5]-error";

    public ContactForm addName(String name){
        WebElement nameId = driver.findElement(By.id(NAME_ID));
        nameId.sendKeys(name);
        return this;
    }

    public ContactForm addLastname(String lastname){
        WebElement lastnameid = driver.findElement(By.id(LASTNAME_ID));
        lastnameid.sendKeys(lastname);
        return this;
    }

    public ContactForm addEmail(String email){
        WebElement emailId = driver.findElement(By.id(EMAIL_ID));
        emailId.sendKeys(email);
        return this;
    }

    public ContactForm clickSubmit(){
        WebElement clickSubmit = driver.findElement(By.id(SUBMIT));
        clickSubmit.click();
        return this;
    }

    public boolean accessPassError(){
        try {
            WebElement passError = driver.findElement(By.id(ACCESS_ERROR));
            return passError.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public boolean sessionError(){
        try{
            WebElement sessionError = driver.findElement(By.id(SESSION_ERROR));
            return sessionError.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public boolean overnightError(){
        try{
            WebElement overnightError = driver.findElement(By.id(OVERNIGHT_ERROR));
            return overnightError.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


}
