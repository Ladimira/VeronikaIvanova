package homework3.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    //main content
    @FindBy (id="iframe")
    public WebElement iframe;
    @FindBy (className="benefit-icon")
    public List<WebElement> images;
    @FindBy (className="benefit-txt")
    public List<WebElement> textboxes;
    @FindBy (css="\"h3.text-center a\"")
    public WebElement subHeader;
    @FindBy (name="main-title")
    public WebElement mainTitle;
    @FindBy (name="jdi-text")
    public WebElement jdiText;
    //iframe contents
    public WebElement epamLogo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe(){
        driver.switchTo().frame(iframe);
        epamLogo = driver.findElement(By.id("epam-logo"));
    }

    public void switchBack(){
        driver.switchTo().parentFrame();
    }
}
