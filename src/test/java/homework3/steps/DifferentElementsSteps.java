package homework3.steps;

import homework3.enums.Checkboxes;
import homework3.enums.Radiobuttons;
import homework3.enums.ServiceMenu;
import homework3.voids.BasePage;
import homework3.voids.DifferentElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        basePage.getTopMenu().get(2).click();
        int i = 0;
        if(!basePage.checkListLength(basePage.getServiceTopMenu(),ServiceMenu.COMPLEX_TABLE)){
            assertTrue(false);
            return;
        }
        for(ServiceMenu menuItem:ServiceMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size serviceLeftMenu will be less then ServiceMenu.values() :done

            assertEquals(basePage.getServiceTopMenu().get(i).getText(),menuItem.name().toUpperCase());
            assertTrue(basePage.getServiceTopMenu().get(i).isDisplayed());
            i++;
        }
    }

    public void assertServiceLeft() {
        basePage.getLeftMenu().get(2).click();
        int i = 0;
        if(!basePage.checkListLength(basePage.getServiceTopMenu(),ServiceMenu.COMPLEX_TABLE)){
            assertTrue(false);
            return;
        }
        for(ServiceMenu menuItem:ServiceMenu.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size serviceLeftMenu will be less then ServiceMenu.values() : done
            assertEquals(basePage.getServiceLeftMenu().get(i).getText(),menuItem.name());
            assertTrue(basePage.getServiceLeftMenu().get(i).isDisplayed());
            i++;
        }
    }

    public void openDifferentElemsPage(String diffElemsUrl) {
        basePage.getServiceLeftMenu().get(7).click();
        differentElementsPage = new DifferentElementsPage(driver);
        assertEquals(driver.getCurrentUrl(), diffElemsUrl);
    }

    public void assertElemsOnPage() {
        int i = 0;
        for (Radiobuttons btn:Radiobuttons.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size radios will be less then Radiobuttons.values() : done
            if(!basePage.checkListLength(differentElementsPage.getRadios(),Radiobuttons.BRONZE)){
                assertTrue(false);
                return;
            }
            assertEquals(differentElementsPage.getRadios().get(i).getText(),btn.name());
            assertTrue(differentElementsPage.getRadios().get(i).isDisplayed());
            assertTrue(differentElementsPage.getRadios().get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
        i = 0;
        for (Checkboxes btn:Checkboxes.values()){
            // TODO You will have here Nu;;pPointer Exception
            // TODO If size checkboxes will be less then Checkboxes.values():done
            if(!basePage.checkListLength(differentElementsPage.getCheckboxes(),Checkboxes.WATER)){
                assertTrue(false);
                return;
            }
            assertEquals(differentElementsPage.getCheckboxes().get(i).getText(),btn.name());
            assertTrue(differentElementsPage.getCheckboxes().get(i).isDisplayed());
            assertTrue(differentElementsPage.getCheckboxes().get(i).findElement(By.tagName("input")).isDisplayed());
            i++;
        }
        assertTrue(differentElementsPage.getButton().isDisplayed());
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
        assertTrue(differentElementsPage.getColorsDropdown().isDisplayed());
    }


    public void assertRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    public void assertLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
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
        differentElementsPage.getColorsSelect().selectByValue(value);
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
