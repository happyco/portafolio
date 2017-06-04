package tasks;

import org.openqa.selenium.WebDriver;
import elements.oLogIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tLogIn {
    public WebDriver driver = null;
    oLogIn elem = new oLogIn();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        elem.setDriver(this.driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

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
        elem.obButton().click();
    }

    public WebElement checkUserErr(){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elem.obButton()));
    }
}
