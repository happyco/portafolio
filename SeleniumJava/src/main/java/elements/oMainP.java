package elements;

import Environment.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class oMainP {
    public WebDriver driver = Environment.getInstance().driver;
    WebDriverWait wait = new WebDriverWait(this.driver, 10);

    public List<WebElement> obBrand(){
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"brandSelect\"]")));
        this.driver.findElement(By.xpath("//*[@id=\"brandSelect\"]")).click();

        return this.wait.until(ExpectedConditions.visibilityOfAllElements(this.driver.findElements(
                By.xpath("//*[@id=\"brand\"]/li"))));

    }

    public List<WebElement> obModel(){
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modelSelect\"]")));
        this.driver.findElement(By.xpath("//*[@id=\"modelSelect\"]")).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(this.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"modelSelect\"]")))).click(this.wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id=\"modelSelect\"]"))));
        builder.perform();


        return this.wait.until(ExpectedConditions.visibilityOfAllElements(this.driver.findElements(
                By.xpath("//*[@id=\"model\"]/li"))));

    }

    public List<WebElement> obYear() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"yearSelect\"]")));
        //this.driver.findElement(By.xpath("///*[@id=\"yearSelect\"]")).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(this.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"yearSelect\"]")))).click(this.wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"yearSelect\"]"))));
        builder.perform();

        return this.wait.until(ExpectedConditions.visibilityOfAllElements(this.driver.findElements(
                By.xpath("//*[@id=\"year\"]/li"))));

    }

    public WebElement obCotButton(){

        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToStep2")));
    }

    public List<WebElement> obTextSell(){

        return this.wait.until(ExpectedConditions.visibilityOfAllElements(
                this.driver.findElements(By.xpath("//*[@id=\"sellHeaderDetails\"]/h2"))));
    }
}
