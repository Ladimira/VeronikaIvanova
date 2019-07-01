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
        if(!homePage.checkListLength(homePage.getTopMenu(),MainMenu.CONTACT_FORM)){
            assertTrue(false);
            return;
        }
        for(MainMenu menuItem:MainMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size topMenu will be less then MainMenu.values() : done
            assertEquals(homePage.getTopMenu().get(i).getText(),menuItem.name().toUpperCase());
            assertTrue(homePage.getTopMenu().get(i).isDisplayed());
            i++;
        }
    }

    public void assertImages(){
        assertEquals(homePage.getImages().size(), 4);
        for(WebElement img: homePage.getImages()){
            assertTrue(img.isDisplayed());
        }
    }

    public void assertImageTexts(List<String> imageTexts){
        assertEquals(homePage.getTextboxes().size(), 4);
        for(WebElement text: homePage.getTextboxes()){
            assertTrue(text.isDisplayed());
            assertEquals(text.getText(),imageTexts.get(homePage.getTextboxes().indexOf(text)));
        }
    }

    public void assertMainHeader(String mainTitle, String jdiText){
        assertEquals(homePage.getMainTitle().getText(),mainTitle);
        assertEquals(homePage.getJdiText().getText(),jdiText.toUpperCase());
    }

    public void assertIframe(){
        assertTrue(homePage.getIframe().isDisplayed());
    }

    public void assertLogo(){
        homePage.switchToIframe();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchBack();
    }

    public void assertSubHeader(String subHeader){
        assertTrue(homePage.getSubHeader().isDisplayed());
        assertEquals(homePage.getSubHeader().getText(),subHeader);
    }

    public void assertSubHeaderIsLink(String subHeaderLink){
        assertEquals(homePage.getSubHeader().getTagName(),"a");
        assertEquals(homePage.getSubHeader().getAttribute("href"),subHeaderLink);
    }

    public void assertLeftSection(){
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void assertFooter(){
        assertTrue(homePage.getFooter().isDisplayed());
    }
}
