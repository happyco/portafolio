package tasks;

import Environment.Environment;
import elements.oMainP;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class tMainP {
    public WebDriver driver = Environment.getInstance().driver;
    oMainP elem = new oMainP();

    public void selectBrand (String brand){
        WebElement i = null;
        for (WebElement element: this.elem.obBrand()) {
            if (element.getText().equals(brand)){
                i = element;
                break;
            }

        }

        i.click();

    }

    public void selectModel (String model){
        WebElement i = null;
        for (WebElement element: this.elem.obModel()) {
            if (element.getText() == model){
                i = element;
                break;
            }

        }
        i.click();
    }

    public void selectYear (String year){
        WebElement i = null;
        for (WebElement element: this.elem.obYear()) {
            if (element.getText() == year){
                i = element;
                break;
            }

        }
        i.click();
    }

    public void clickCot (){
        this.elem.obCotButton().click();
    }
}
