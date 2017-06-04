package tasks;

import Environment.Environment;
import org.openqa.selenium.WebDriver;
import elements.oLogIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tLogIn {
    public WebDriver driver = Environment.getInstance().driver;
    oLogIn elem = new oLogIn();

    public void go (String site){
        this.driver.get(site);
    }

    public void setUSerTxt(String user){
        elem.obUSerTxt().sendKeys(user);
    }

    public void setPwdTxt(String password){
        elem.obPwdTxt().sendKeys(password);
    }

    public void clickButton(){
        elem.obButton().submit();
    }

    public WebElement checkUserErr(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elem.obUserErr()));
    }
}
