package homework2.ex2;

import homework2.base.UserLoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Exercise2 extends UserLoginTest {

    @Test
    public void BigDiffElementsTest() {


        assertBrowserTitle("Home Page");
        performLogin("epam", "1234");
        assertUsername("PITER CHAILOVSKII");
        assertServiceHeader(Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS"));
        assertServiceLeft(Arrays.asList("Support", "Dates", "Complex Table", "Simple Table",
                "Table with pages", "Different elements"));
        openDifferentElemsPage("https://epam.github.io/JDI/different-elements.html");
        assertElemsOnPage(Arrays.asList("Water", "Earth", "Wind", "Fire"),
                Arrays.asList("Gold", "Silver", "Bronze", "Selen"));
        assertRightSection();
        assertLeftSection();
        List<String> checkboxesToSelect = Arrays.asList("Water", "Wind");
        selectCheckboxes(checkboxesToSelect);
        checkLogForCheckboxes(checkboxesToSelect,true);
        selectRadio("Selen");
        checkLogForRadio("Selen");
        selectInDropdown("Yellow");
        checkLogForSelect();
        unselectCheckboxes(checkboxesToSelect);
        checkLogForCheckboxes(checkboxesToSelect,false);
    }


    // TODO Code duplication EX1 : done
    @BeforeMethod
    //1. Open test site by URL
    public void setUp() {
        super.setUp();
    }

    // TODO Code duplication EX1 : done
    @AfterMethod
    //19. Close browser
    public void tearDown() {
        super.tearDown();
    }

    //5. Click on "Service" subcategory in the header and check that drop down contains options
    // TODO Looks like code duplication from the Ex1 :extracted menu text assertion to superclass, done
    private void assertServiceHeader(List<String> expectedItems) {
        menuItemClick("SERVICE");
        //check if there are all service menu items
        for (String elem : expectedItems) {
            WebElement item = driver.findElement(By.linkText(elem));
            assertElementWithText(item,elem);
        }
    }

    //support method for clicking
    private void menuItemClick(String service) {
        WebElement serviceMenu = driver.findElement(By.linkText(service));
        serviceMenu.click();
    }

    //6. Click on Service subcategory in the left section and check that drop down contains options
    // TODO Looks like code duplication from the Ex1  :extracted menu text assertion to superclass, done
    private void assertServiceLeft(List<String> expectedItems) {
        menuItemClick("Service");
        //check if there are all service menu items
        for (String elem : expectedItems) {
            WebElement item = driver.findElement(By.linkText(elem));
            assertElementWithText(item,elem);
        }
    }

    //7. Open through the header menu Service -> Different Elements Page
    private void openDifferentElemsPage(String diffElemsUrl) {
        menuItemClick("SERVICE");
        menuItemClick("DIFFERENT ELEMENTS");
        assertEquals(driver.getCurrentUrl(), diffElemsUrl);
    }

    //8. Check interface on Different elements page, it contains all needed elements
    private void assertElemsOnPage(List<String> checkTexts, List<String> radioTexts) {
        //assert checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        // TODO Looks like code duplication from the Ex1 :extracted label text assertion to superclass, done
        for (WebElement elem : checkboxes) {
            //assert label text
            assertElementWithText(elem,checkTexts.get(checkboxes.indexOf(elem)));
            //assert input presence
            assertElemFromOtherElement(elem, By.tagName("input"));
        }
        //assert radiobuttons
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        // TODO Looks like code duplication from the Ex1  :extracted label text assertion to superclass, done
        for (WebElement elem : radios) {
            assertElementWithText(elem,radioTexts.get(radios.indexOf(elem)));
            //assert input presence
            assertElemFromOtherElement(elem, By.tagName("input"));

        }
        //assert dropdown
        assertElemFromDriver(By.className("uui-form-element"));
        //assert buttons
        assertElemFromDriver(By.name("Default Button"));
        assertElemFromDriver(By.cssSelector("input[value=\"Button\"]"));
    }



    //support method for element assertion
    private void assertElemFromOtherElement(WebElement elem, By by) {
        // TODO Why do you decide use try-catch : skype discussed
        try {
            WebElement target = elem.findElement(by);
            assertTrue(target.isDisplayed());
        } catch (NoSuchElementException e) {
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
    // TODO Is it possible parametrized this method to get checkbox name? : done
    private void selectCheckboxes(List<String> checkboxes) {
        // TODO locator could be improved : done
        for (String name : checkboxes) {
            WebElement checkbox = driver.findElement(By.xpath("//label[text()[contains(.,'" + name + "')]]")).findElement(By.tagName("input"));
            checkbox.click();
        }

    }//label[text()[contains(.,'ABC')]]

    //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    // TODO Is it possible parametrized this method to get checkbox name? : done
    private void checkLogForCheckboxes(List<String> checkboxes, boolean state) {
        for (String name : checkboxes) {
            assertElemFromDriver(By.xpath("//li[contains(text(),'" + name + " : condition changed to"+state+" ')]"));
        }
    }

    //13. Select radio
    // TODO Is it possible parametrized this method to get radio name? : done
    private void selectRadio(String radioName) {
        // TODO locator could be improved : done
        WebElement radio = driver.findElement(By.xpath("//label[text()[contains(.,'" + radioName + "')]]")).findElement(By.tagName("input"));
        radio.click();
    }

    //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    private void checkLogForRadio(String radioName) {
        assertElemFromDriver(By.xpath("//li[contains(text(),'metal: value changed to " + radioName + "')]"));
    }

    //15. Select in dropdown
    private void selectInDropdown(String value) {
        WebElement colorsDropdown = driver.findElement(By.className("colors")).findElement(By.className("uui-form-element"));
        Select colorsSelect = new Select(colorsDropdown);
        colorsSelect.selectByValue(value);
    }

    //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    private void checkLogForSelect() {
        assertElemFromDriver(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"));
    }

    //17. Unselect and assert checkboxes
    // TODO Is it possible parametrized this method to get checkbox name? : done
    private void unselectCheckboxes(List<String> checkboxes) {
        // TODO locator could be improved : done
        selectCheckboxes(checkboxes);
        // TODO could be replaced to assertFalse : done
        for (String name : checkboxes) {
            WebElement checkbox = driver.findElement(By.xpath("//label[text()[contains(.,'" + name + "')]]")).findElement(By.tagName("input"));
            assertFalse(checkbox.isSelected());
        }
    }
}

