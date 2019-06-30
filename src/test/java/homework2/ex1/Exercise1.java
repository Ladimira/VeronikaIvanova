package homework2.ex1;

import homework2.base.UserLoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Exercise1 extends UserLoginTest {

    @Test
    public void BigLoginTest()
    {
        assertBrowserTitle("Home Page");
        performLogin("epam","1234");
        assertUsername("PITER CHAILOVSKII");
        assertMenu(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        assertImages();
        assertImageText(Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
        assertMainHeader("EPAM FRAMEWORK WISHES…",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
        assertIframe();
        assertEpamLogo();
        switchToParent();
        assertSubHeader("JDI GITHUB");
        assertLink("https://github.com/epam/JDI");
        assertLeftSection();
        assertFooter();
    }


    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    private void assertMenu(List<String> expectedItems){
        //check if there are 4 menu items
        for(String elem: expectedItems){
            WebElement item = driver.findElement(By.linkText(elem));
            //Check if menu item is displayed
            assertTrue(item.isDisplayed());
            //check item text
            assertEquals(item.getText(),elem);
        }
    }

    //7. Assert that there are 4 images on the Index Page and they are displayed
    private void assertImages(){
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        //check if there are 4 images
        assertEquals(images.size(),4);
        for(WebElement elem: images){
            //Check if menu item is displayed
            assertTrue(elem.isDisplayed());
        }
    }

    //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
    private void assertImageText(List<String> expectedText){
        List<WebElement> textboxes = driver.findElements(By.className("benefit-txt"));
        //check if there are 4 textboxes
        assertEquals(textboxes.size(),4);
        for(WebElement elem: textboxes){
            assertElementWithText(elem,expectedText.get(textboxes.indexOf(elem)));
        }
    }

    //9. Assert a text of the main headers
    private void assertMainHeader(String mainTitle, String jdiText) {
        //assert main title
        WebElement mainTitleElem = driver.findElement(By.name("main-title"));
        assertEquals(mainTitleElem.getText(),mainTitle);
        //assert second title
        WebElement jdiTextElem = driver.findElement(By.name("jdi-text"));
        assertEquals(jdiTextElem.getText(),jdiText.toUpperCase());
    }

    //10. Assert that there is the iframe in the center of page
    private void assertIframe(){
        assertElemFromDriver(By.id("iframe"));
    }

    //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    private void assertEpamLogo(){
        //switch to iframe
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        //assert epam logo
        try {
        WebElement logo = driver.findElement(By.id("epam_logo"));
        assertTrue(logo!=null);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        assertElemFromDriver(By.id("epam_logo"));

    }

    //12. Switch to original window back
    private void switchToParent(){
        driver.switchTo().parentFrame();
    }

    //13. Assert a text of the sub header
    private void assertSubHeader(String subHeaderText){
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center a"));
        assertEquals(subHeader.getText(),subHeaderText);
    }

    //14. Assert that JDI GITHUB is a link and has a proper URL
    private void assertLink(String linkUrl){
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center a"));
        //assert is link
        assertEquals(subHeader.getTagName(),"a");
        //assert href
        assertEquals(subHeader.getAttribute("href"),linkUrl);
    }

    //15. Assert there is a Left Section
    private void assertLeftSection(){
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());
    }

    //16. Assert there is a Footer
    private void assertFooter(){
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());
    }

}
