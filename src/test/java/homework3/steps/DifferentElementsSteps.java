package homework3.steps;

import homework3.enums.Checkboxes;
import homework3.enums.Radiobuttons;
import homework3.enums.ServiceMenu;
import homework3.voids.BasePage;
import homework3.voids.DifferentElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.*;

public class DifferentElementsSteps {
    private WebDriver driver;
    private BasePage basePage;
    private DifferentElementsPage differentElementsPage;

    public DifferentElementsSteps(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public void assertServiceHeader() {
        basePage.topMenu.get(2).click();
        int i = 0;
        for(ServiceMenu menuItem:ServiceMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size serviceLeftMenu will be less then ServiceMenu.values()
            assertEquals(basePage.serviceTopMenu.get(i).getText(),menuItem.name().toUpperCase());
            assertTrue(basePage.serviceTopMenu.get(i).isDisplayed());
            i++;
        }
    }

    public void assertServiceLeft() {
        basePage.leftMenu.get(2).click();
        int i = 0;
        for(ServiceMenu menuItem:ServiceMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size serviceLeftMenu will be less then ServiceMenu.values()
            assertEquals(basePage.serviceLeftMenu.get(i).getText(),menuItem.name());
            assertTrue(basePage.serviceLeftMenu.get(i).isDisplayed());
            i++;
        }
    }

    public void openDifferentElemsPage(String diffElemsUrl) {
        basePage.serviceLeftMenu.get(7).click();
        differentElementsPage = new DifferentElementsPage(driver);
        assertEquals(driver.getCurrentUrl(), diffElemsUrl);
    }

    public void assertElemsOnPage() {
        int i = 0;
        for (Radiobuttons btn:Radiobuttons.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size radios will be less then Radiobuttons.values()
            assertEquals(differentElementsPage.radios.get(i).getText(),btn.name());
            assertTrue(differentElementsPage.radios.get(i).isDisplayed());
            assertTrue(differentElementsPage.radios.get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
        i = 0;
        for (Checkboxes btn:Checkboxes.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size checkboxes will be less then Checkboxes.values()
            assertEquals(differentElementsPage.checkboxes.get(i).getText(),btn.name());
            assertTrue(differentElementsPage.checkboxes.get(i).isDisplayed());
            assertTrue(differentElementsPage.checkboxes.get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
        assertTrue(differentElementsPage.button.isDisplayed());
        assertTrue(differentElementsPage.defaultButton.isDisplayed());
        assertTrue(differentElementsPage.colorsDropdown.isDisplayed());
    }


    public void assertRightSection() {
        assertTrue(differentElementsPage.rightSection.isDisplayed());
    }

    public void assertLeftSection() {
        assertTrue(differentElementsPage.leftSection.isDisplayed());
    }

    public void selectCheckboxes(List<String> checkboxes) {
        for (String name : checkboxes) {
            differentElementsPage.findCheckboxByName(name).click();
        }

    }

    public void checkLogForCheckboxes(List<String> checkboxes, boolean state) {
        for (String name : checkboxes) {
            differentElementsPage.findLogLine(name + " : condition changed to "+state);
        }
    }

    public void selectRadio(String radioName) {
        differentElementsPage.findRadioByName(radioName).click();
    }

    public void checkLogForRadio(String radioName) {
        differentElementsPage.findLogLine("metal: value changed to "+radioName);
    }

    public void selectInDropdown(String value) {
        differentElementsPage.colorsSelect.selectByValue(value);
    }

    public void checkLogForSelect(String value) {
        differentElementsPage.findLogLine("Colors: value changed to "+value);
    }

    public void unselectCheckboxes(List<String> checkboxes) {
        selectCheckboxes(checkboxes);
        for (String name : checkboxes) {
            WebElement chk = differentElementsPage.findCheckboxByName(name);
            chk.click();
            assertFalse(chk.isSelected());
        }
    }
}
