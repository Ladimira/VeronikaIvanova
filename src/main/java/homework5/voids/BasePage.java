package homework5.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    //top menu
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li>a")
    List<WebElement> topMenu;

    //service top menu
    List<WebElement> serviceTopMenu;

    //left-side menu
    @FindBy(name = "navigation-sidebar")
    WebElement leftSection;
    @FindBy(css="ul.sidebar-menu>li>a")
    List<WebElement> leftMenu;

    //service left menu
    @FindBy(css="ul.sub>li>a")
    List<WebElement> serviceLeftMenu;

    //login fields
    @FindBy(css = "a[href=\"#\"]")
    WebElement dropDownButton;
    @FindBy (id="name")
    WebElement loginBox;
    @FindBy (id="password")
    WebElement passwordBox;
    @FindBy (id="login-button")
    WebElement loginButton;
    WebElement nameLabel;

    //footer
    @FindBy (css="footer")
    WebElement footer;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getTopMenu() {
        return topMenu;
    }

    public List<WebElement> getServiceTopMenu() {
        serviceTopMenu = driver.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
        return serviceTopMenu;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public List<WebElement> getLeftMenu() {
        return leftMenu;
    }

    public List<WebElement> getServiceLeftMenu() {
        return serviceLeftMenu;
    }

    public WebElement getDropDownButton() {
        return dropDownButton;
    }

    public WebElement getLoginBox() {
        return loginBox;
    }

    public WebElement getPasswordBox() {
        return passwordBox;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getNameLabel() {
        return nameLabel;
    }

    public WebElement getFooter() {
        return footer;
    }

    public void login(String login, String password){
        dropDownButton.click();
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        loginButton.click();
        nameLabel = driver.findElement(By.id("user-name"));
    }

    public <E extends Enum> boolean  checkListLength(List<WebElement> list, E checkedEnum){
        return list.size()==checkedEnum.getDeclaringClass().getEnumConstants().length;
    }
}
