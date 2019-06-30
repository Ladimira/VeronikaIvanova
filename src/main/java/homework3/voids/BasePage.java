package homework3.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    // TODO Why do you deide make fields public?
    //top menu
    @FindBy(css = "ul.m-18>li>a")
    public List<WebElement> topMenu;

    //service top menu
    @FindBy(css="ul.dropdown-menu>li>a")
    public List<WebElement> serviceTopMenu;

    //left-side menu
    @FindBy(className="navigation-sidebar")
    public WebElement leftSection;
    @FindBy(css="ul.sidebar-menu>li>a")
    public List<WebElement> leftMenu;

    //service left menu
    @FindBy(css="ul.sub>li>a")
    public List<WebElement> serviceLeftMenu;

    //login fields
    @FindBy(css = "a[href=\"#\"]")
    public WebElement dropDownButton;
    @FindBy (id="name")
    public WebElement loginBox;
    @FindBy (id="password")
    public WebElement passwordBox;
    @FindBy (id="login-button")
    public WebElement loginButton;
    public WebElement nameLabel;

    //footer
    @FindBy (css="footer")
    public WebElement footer;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // TODO Which style we use for method and field names?
    public void Login(String login, String password){
        dropDownButton.click();
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        loginButton.click();
        nameLabel = driver.findElement(By.id("user-name"));
    }
}
