package homework6.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    //main content
    @FindBy(className = "benefit-icon")
    List<WebElement> images;
    @FindBy(className = "benefit-txt")
    List<WebElement> textboxes;
    @FindBy(css = "\"h3.text-center a\"")
    WebElement subHeader;
    @FindBy(name = "main-title")
    WebElement mainTitle;

    public HomePage(WebDriver driver) {
        super(driver);
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


}
