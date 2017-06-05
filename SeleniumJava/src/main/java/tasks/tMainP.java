package tasks;

import Environment.Environment;
import elements.oMainP;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.TreeSet;

public class tMainP {
    public WebDriver driver = Environment.getInstance().driver;
    oMainP elem = new oMainP();
    Set<String> data = new TreeSet<String>();
    String brand = null, model = null, year = null;

    public void selectBrand (String brand){
        WebElement i = null;
        for (WebElement element: this.elem.obBrand()) {
            if (element.getText().equals(brand)){
                i = element;
                break;
            }

        }

        i.click();
        this.brand = brand;

    }

    public void selectModel (String model){
        WebElement i = null;
        for (WebElement element: this.elem.obModel()) {
            if (element.getText().equals(model)){
                i = element;
                break;
            }

        }
        i.click();
        this.model = model;
    }

    public void selectYear (String year){
        WebElement i = null;
        for (WebElement element: this.elem.obYear()) {
            if (element.getText().equals(year)){
                i = element;
                break;
            }

        }
        i.click();
        this.year = year;
    }

    public void clickCot (){
        this.elem.obCotButton().click();
    }

    public Boolean verifySell(){
        String check = this.brand + " " + this.model + " "+ this.year;

        if (this.brand != null & this.model != null & this.year != null){

            for (WebElement element : this.elem.obTextSell()) {
                if (element.getText().equals(check)) {
                    return Boolean.TRUE;
                }

                System.out.println(element.getText());

            }
        }
        return Boolean.FALSE;
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
