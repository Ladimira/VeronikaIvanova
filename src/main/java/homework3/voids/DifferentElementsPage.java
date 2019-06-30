package homework3.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends BasePage
{


    //sections
    @FindBy (className = "right-fix-panel")
    public WebElement rightSection;
    //checkboxes
    @FindBy (className = "label-checkbox")
    public List<WebElement> checkboxes;
    //radiobuttons
    @FindBy (className = "label-radio")
    public List<WebElement> radios;
    //select
    @FindBy(className = "uui-form-element")
    public WebElement colorsDropdown;
    public Select colorsSelect;
    //buttons
    @FindBy (name="Default Button")
    public WebElement defaultButton;
    @FindBy (css="input[value=\"Button\"]")
    public WebElement button;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        colorsSelect = new Select(colorsDropdown);
    }

    public WebElement findLogLine(String line){
        return driver.findElement(By.xpath("//li[contains(text(),'" + line+" ')]"));
    }

    public WebElement findCheckboxByName(String name){
        for(WebElement elem:checkboxes){
            if(elem.getText().equals(name))
                return  elem;
        }
        return null;
    }

    public WebElement findRadioByName(String name){
        for(WebElement elem:radios){
            if(elem.getText().equals(name))
                return  elem;
        }
        return null;
    }
}
