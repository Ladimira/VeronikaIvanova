package Homework2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Exercise1 {
    private WebDriver driver;

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


    @BeforeMethod
    //1. Open test site by URL
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://epam.github.io/JDI/");
    }

    @AfterMethod
    //17. Close browser
    public void tearDown() {
        driver.quit();
    }

    //2. Assert browser title
    private void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

     //3. Perform login
    private void performLogin(String login, String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //click on dropdown arrow
        WebElement dropDownButton = driver.findElement(By.cssSelector("a[href=\"#\"]"));
        dropDownButton.click();
        //enter login and password
        WebElement loginBox = driver.findElement(By.id("name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        //click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    //4. Assert username
    private void assertUsername(String username) {
        //assert username
        WebElement nameLabel = driver.findElement(By.id("user-name"));
        assertEquals(nameLabel.getText(),username);
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
            //Check if textbox is displayed
            assertTrue(elem.isDisplayed());
            //check text
            assertEquals(elem.getText(),expectedText.get(textboxes.indexOf(elem)));
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
        try {
            WebElement iframe = driver.findElement(By.id("iframe"));
            assertTrue(iframe != null);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }

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
        assertTrue(leftSection!=null);
    }

    //16. Assert there is a Footer
    private void assertFooter(){
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer!=null);
    }

}
