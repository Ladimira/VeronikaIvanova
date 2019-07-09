package homework6.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected static BasePage instance;
    //top menu
    @FindBy(css = "ul.m-18>li>a")
    List<WebElement> topMenu;

    //service top menu
    @FindBy(css = "ul.dropdown-menu>li>a")
    List<WebElement> serviceTopMenu;

    //left-side menu
    @FindBy(className = "navigation-sidebar")
    WebElement leftSection;
    @FindBy(css = "ul.sidebar-menu>li>a")
    List<WebElement> leftMenu;

    //service left menu
    @FindBy(css = "ul.sub>li>a")
    List<WebElement> serviceLeftMenu;

    //login fields
    @FindBy(css = "a[href=\"#\"]")
    WebElement dropDownButton;
    @FindBy(id = "name")
    WebElement loginBox;
    @FindBy(id = "password")
    WebElement passwordBox;
    @FindBy(id = "login-button")
    WebElement loginButton;
    WebElement nameLabel;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getServiceTopMenu() {
        return serviceTopMenu;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }


    public List<WebElement> getServiceLeftMenu() {
        return serviceLeftMenu;
    }

    public WebElement getNameLabel() {
        return nameLabel;
    }


    public void login(String login, String password) {
        dropDownButton.click();
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        loginButton.click();
        nameLabel = driver.findElement(By.id("user-name"));
    }

    public <E extends Enum> boolean checkListLength(List<WebElement> list, E checkedEnum) {
        return list.size() >= checkedEnum.getDeclaringClass().getEnumConstants().length;
    }

    public void menuItemClick(String menuItemName) {
        driver.findElement(By.linkText(menuItemName.toUpperCase())).click();
    }

    public void serviceMenuItemClick(String menuItemName) {
        driver.findElement(By.linkText("SERVICE")).click();
        driver.findElement(By.linkText(menuItemName.toUpperCase())).click();
    }

    public static BasePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new BasePage(driver);
        }
        return instance;
    }


}
