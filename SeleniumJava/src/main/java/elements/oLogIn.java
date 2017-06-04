package elements;

import Environment.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class oLogIn {
    public WebDriver driver = Environment.getInstance().driver;

    public WebElement obUSerTxt(){
        return this.driver.findElement(By.id("email"));
    }

    public WebElement obPwdTxt(){
        return this.driver.findElement(By.id("password"));
    }

    public WebElement obButton(){
        return this.driver.findElement(By.id("form_login"));

    }

    public WebElement obUserErr(){
        return this.driver.findElement(By.id("email-error"));
    }

}