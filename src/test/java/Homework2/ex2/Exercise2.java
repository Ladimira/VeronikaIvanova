package Homework2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 {
    private WebDriver driver;

    @Test
    public void BigDiffElementsTest()
    {
        assertBrowserTitle("Home Page");
        performLogin("epam","1234");
        assertUsername("PITER CHAILOVSKII");
        assertServiceHeader(Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS"));
        assertServiceLeft(Arrays.asList("Support", "Dates", "Complex Table", "Simple Table",
                "Table with pages", "Different elements"));
        openDifferentElemsPage("https://epam.github.io/JDI/different-elements.html");
        assertElemsOnPage(Arrays.asList("Water","Earth","Wind", "Fire"),
                Arrays.asList("Gold","Silver","Bronze","Selen"));
        assertRightSection();
        assertLeftSection();
        selectCheckboxes();
        checkLogForCheckboxes();
        selectRadio();
        checkLogForRadio();
        selectInDropdown("Yellow");
        checkLogForSelect();
        unselectCheckboxes();
        checkLogForCheckboxesFalse();
    }



// TODO Code duplication EX1
    @BeforeMethod
    //1. Open test site by URL
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://epam.github.io/JDI/");
    }

    // TODO Code duplication EX1
    @AfterMethod
    //19. Close browser
    public void tearDown() {
        driver.quit();
    }

    //2. Assert browser title
    // TODO Code duplication EX1
    private void assertBrowserTitle(String expectedTitle) {
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        assertEquals(driver.getTitle(), expectedTitle);
    }

    //3. Perform login
    // TODO Code duplication EX1
    private void performLogin(String login, String password) {
        // TODO Where should be setting implicitly waits???
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //click on dropdown arrow
        // TODO Why do you create this fields?
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
    // TODO Code duplication EX2
    private void assertUsername(String username) {
        //assert username
        WebElement nameLabel = driver.findElement(By.id("user-name"));
        assertEquals(nameLabel.getText(),username);
    }

    //5. Click on "Service" subcategory in the header and check that drop down contains options
    // TODO Looks like code duplication from the Ex1
    private void assertServiceHeader(List<String> expectedItems) {
        menuItemClick("SERVICE");
        //check if there are all service menu items
        for(String elem: expectedItems){
            WebElement item = driver.findElement(By.linkText(elem));
            //Check if menu item is displayed
            assertTrue(item.isDisplayed());
            //check item text
            assertEquals(item.getText(),elem);
        }
    }
    //support method for clicking
    private void menuItemClick(String service) {
        WebElement serviceMenu = driver.findElement(By.linkText(service));
        serviceMenu.click();
    }

    //6. Click on Service subcategory in the left section and check that drop down contains options
    // TODO Looks like code duplication from the Ex1
    private void assertServiceLeft(List<String> expectedItems) {
        menuItemClick("Service");
        //check if there are all service menu items
        for(String elem: expectedItems){
            WebElement item = driver.findElement(By.linkText(elem));
            //Check if menu item is displayed
            assertTrue(item.isDisplayed());
            //check item text
            assertEquals(item.getText(),elem);
        }
    }
    //7. Open through the header menu Service -> Different Elements Page
    private void openDifferentElemsPage(String diffElemsUrl) {
        menuItemClick("SERVICE");
        menuItemClick("DIFFERENT ELEMENTS");
        assertEquals(driver.getCurrentUrl(),diffElemsUrl);
    }

    //8. Check interface on Different elements page, it contains all needed elements
    private void assertElemsOnPage(List<String> checkTexts, List<String> radioTexts){
        //assert checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        // TODO Looks like code duplication from the Ex1
        for(WebElement elem:checkboxes){
            //assert label text
            assertEquals(elem.getText(),checkTexts.get(checkboxes.indexOf(elem)));
            //assert input presence
            assertElemFromOtherElement(elem,By.tagName("input"));
        }
        //assert radiobuttons
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        // TODO Looks like code duplication from the Ex1
        for(WebElement elem:radios){
            //assert label text
            assertEquals(elem.getText(),radioTexts.get(radios.indexOf(elem)));
            //assert input presence
            assertElemFromOtherElement(elem,By.tagName("input"));

        }
        //assert dropdown
        assertElemFromDriver(By.className("uui-form-element"));
        //assert buttons
        assertElemFromDriver(By.name("Default Button"));
        assertElemFromDriver(By.cssSelector("input[value=\"Button\"]"));
    }

    //support method for element assertion
    private void assertElemFromDriver(By by) {
        // TODO Why do you decide use try-catch
        try {
            WebElement elem = driver.findElement(by);
            assertTrue(elem != null);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    //support method for element assertion
    private void assertElemFromOtherElement(WebElement elem,By by) {
        // TODO Why do you decide use try-catch
        try {
            WebElement target = elem.findElement(by);
            assertTrue(target != null);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    //9. Assert that there is Right Section
    private void assertRightSection() {
        assertElemFromDriver(By.className("right-fix-panel"));
    }

    //10. Assert that there is Left Section
    private void assertLeftSection() {
        assertElemFromDriver(By.name("navigation-sidebar"));
    }

    //11. Select checkboxes
    // TODO Is it possible parametrized this method to get checkbox name?
    private void selectCheckboxes(){
        // TODO locator could be improved
        WebElement checkboxWater = driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).findElement(By.tagName("input"));
        WebElement checkboxWind = driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).findElement(By.tagName("input"));
        checkboxWater.click();
        checkboxWind.click();
    }

    //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    // TODO Is it possible parametrized this method to get checkbox name?
    private void checkLogForCheckboxes(){
        assertElemFromDriver(By.xpath("//li[contains(text(),'Water : condition changed to true')]"));
        assertElemFromDriver(By.xpath("//li[contains(text(),'Wind : condition changed to true')]"));
    }
    //13. Select radio
    // TODO Is it possible parametrized this method to get radio name?
    private void selectRadio(){
        // TODO locator could be improved
        WebElement radioSelen = driver.findElement(By.xpath("//label[@class='label-radio'][4]")).findElement(By.tagName("input"));
        radioSelen.click();
    }
    //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    private void checkLogForRadio(){
        assertElemFromDriver(By.xpath("//li[contains(text(),'metal: value changed to Selen')]"));
    }
    //15. Select in dropdown
    private void selectInDropdown(String value){
        WebElement colorsDropdown = driver.findElement(By.className("colors")).findElement(By.className("uui-form-element"));
        Select colorsSelect = new Select(colorsDropdown);
        colorsSelect.selectByValue(value);
    }

    //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    private void checkLogForSelect(){
        assertElemFromDriver(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
    }
    //17. Unselect and assert checkboxes
    // TODO Is it possible parametrized this method to get checkbox name?
    private void unselectCheckboxes(){
        // TODO locator could be improved
        WebElement checkboxWater = driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).findElement(By.tagName("input"));
        WebElement checkboxWind = driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).findElement(By.tagName("input"));
        checkboxWater.click();
        checkboxWind.click();
        // TODO could be replaced to assertFalse
        assertTrue(!checkboxWater.isSelected());
        assertTrue(!checkboxWind.isSelected());
    }
    //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    private void checkLogForCheckboxesFalse(){
        assertElemFromDriver(By.xpath("//li[contains(text(),'Water : condition changed to false')]"));
        assertElemFromDriver(By.xpath("//li[contains(text(),'Wind : condition changed to false')]"));
    }
}
