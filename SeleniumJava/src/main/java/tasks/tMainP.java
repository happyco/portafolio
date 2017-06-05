package tasks;

import Environment.Environment;
import elements.oMainP;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class tMainP {
    public WebDriver driver = Environment.getInstance().driver;
    oMainP elem = new oMainP();
    Set<String> data = new TreeSet<String>();

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

    public Boolean getBrandList(){

        gData restdata = new gData();
        try {
            this.data = restdata.getHTML("https://carmatch.mx/api/quotations/brands?filter%5Bquotations%5D%5Bactive%5D=1&fields%5%20Bbrands%5D=name&sort=name");
        }catch (Exception e){
            System.out.println(e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean compareRestDropdown(){
        Set<String> uibrand = new TreeSet<String>();

        for (WebElement element: this.elem.obBrand()) {
            uibrand.add(element.getText());
            }



        if (uibrand.containsAll(this.data) && this.data.containsAll(uibrand)){
            return Boolean.TRUE;
        }
        System.out.println(uibrand.size());
        System.out.println("");
        System.out.println(this.data.size());
        System.out.println("");
        System.out.println(uibrand);
        System.out.println("");
        System.out.println(this.data);

        return Boolean.FALSE;
    }
}
