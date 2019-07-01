package homework3.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    // TODO Why do you deide make fields public? :done

    public WebElement getIframe() {
        return iframe;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTextboxes() {
        return textboxes;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getJdiText() {
        return jdiText;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    //main content
    @FindBy (id="iframe")
    WebElement iframe;
    @FindBy (className="benefit-icon")
    List<WebElement> images;
    @FindBy (className="benefit-txt")
    List<WebElement> textboxes;
    @FindBy (css="\"h3.text-center a\"")
    WebElement subHeader;
    @FindBy (name="main-title")
    WebElement mainTitle;
    @FindBy (name="jdi-text")
    WebElement jdiText;
    //iframe contents
    WebElement epamLogo;

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
