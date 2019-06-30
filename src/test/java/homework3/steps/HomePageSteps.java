package homework3.steps;

import homework3.enums.MainMenu;
import homework3.voids.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {
    private WebDriver driver;
    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void assertMenu(){
        int i = 0;
        for(MainMenu menuItem:MainMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size topMenu will be less then MainMenu.values()
            assertEquals(homePage.topMenu.get(i).getText(),menuItem.name().toUpperCase());
            assertTrue(homePage.topMenu.get(i).isDisplayed());
            i++;
        }
    }

    public void assertImages(){
        assertEquals(homePage.images.size(), 4);
        for(WebElement img:homePage.images){
            assertTrue(img.isDisplayed());
        }
    }

    public void assertImageTexts(List<String> imageTexts){
        assertEquals(homePage.textboxes.size(), 4);
        for(WebElement text:homePage.textboxes){
            assertTrue(text.isDisplayed());
            assertEquals(text.getText(),imageTexts.get(homePage.textboxes.indexOf(text)));
        }
    }

    public void assertMainHeader(String mainTitle, String jdiText){
        assertEquals(homePage.mainTitle.getText(),mainTitle);
        assertEquals(homePage.jdiText.getText(),jdiText.toUpperCase());
    }

    public void assertIframe(){
        assertTrue(homePage.iframe.isDisplayed());
    }

    public void assertLogo(){
        homePage.switchToIframe();
        assertTrue(homePage.epamLogo.isDisplayed());
        homePage.switchBack();
    }

    public void assertSubHeader(String subHeader){
        assertTrue(homePage.subHeader.isDisplayed());
        assertEquals(homePage.subHeader.getText(),subHeader);
    }

    public void assertSubHeaderIsLink(String subHeaderLink){
        assertEquals(homePage.subHeader.getTagName(),"a");
        assertEquals(homePage.subHeader.getAttribute("href"),subHeaderLink);
    }

    public void assertLeftSection(){
        assertTrue(homePage.leftSection.isDisplayed());
    }

    public void assertFooter(){
        assertTrue(homePage.footer.isDisplayed());
    }
}
