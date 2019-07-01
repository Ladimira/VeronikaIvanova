package homework3.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends BasePage
{

    // TODO Why do you deide make fields public? : done

    //sections
    @FindBy (className = "right-fix-panel")
    WebElement rightSection;
    //checkboxes
    @FindBy (className = "label-checkbox")
    List<WebElement> checkboxes;
    //radiobuttons
    @FindBy (className = "label-radio")
    List<WebElement> radios;
    //select
    @FindBy(className = "uui-form-element")
    WebElement colorsDropdown;
    Select colorsSelect;
    //butons
    @FindBy (name="Default Button")
     WebElement defaultButton;
    @FindBy (css="input[value=\"Button\"]")
    WebElement button;

    public WebElement getRightSection() {
        return rightSection;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public WebElement getColorsDropdown() {
        return colorsDropdown;
    }

    public Select getColorsSelect() {
        return colorsSelect;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getButton() {
        return button;
    }

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
