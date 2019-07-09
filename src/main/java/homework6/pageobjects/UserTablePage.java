package homework6.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends BasePage {

    @FindBy(css = "#user-table tr>td:nth-child(0)")
    private List<WebElement> userNumbers;
    @FindBy(css = "#user-table tr>td:nth-child(1)")
    private List<WebElement> userTypes;
    @FindBy(css = "#user-table tr>td:nth-child(2)>a")
    private List<WebElement> userNames;
    @FindBy(css = "#user-table tr>td:nth-child(1)>select")
    private List<Select> userTypeSelects;
    @FindBy(css = "#user-table tr>td:nth-child(3) input")
    private List<WebElement> userChecks;
    @FindBy(css = "#user-table tr>td:nth-child(3) img")
    private List<WebElement> userPics;
    @FindBy(css = "#user-table tr>td:nth-child(3) span")
    private List<WebElement> userDescrs;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public WebElement findLogLine(String line){
        return driver.findElement(By.xpath("//li[contains(text(),'" + line+" ')]"));
    }

    public List<WebElement> getUserNumbers() {
        return userNumbers;
    }

    public List<WebElement> getUserTypes() {
        return userTypes;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<Select> getUserTypeSelects() {
        return userTypeSelects;
    }

    public List<WebElement> getUserChecks() {
        return userChecks;
    }

    public List<WebElement> getUserPics() {
        return userPics;
    }

    public List<WebElement> getUserDescrs() {
        return userDescrs;
    }


    public void selectCheckByUserName(String userName){
        userChecks.get(userNames.indexOf(userName)).click();
    }

    public void clickDropdownByUserName(String userName){
        userTypes.get(userNames.indexOf(userName)).click();
    }
}
