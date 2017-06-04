package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class oLogIn {
    public WebDriver driver = null;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement obUSerTxt(){
        return this.driver.findElement(By.id("email"));
    }

    public WebElement obPwdTxt(){
        return this.driver.findElement(By.id("password"));
    }

    public WebElement obButton(){
        return this.driver.findElement(By.xpath("'//*[@id=\"form_login\"]/button'"));
    }

    public By obUserErr(){
        return By.id("email-error");
    }

}