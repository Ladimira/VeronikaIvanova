package homework3;

import homework3.steps.DifferentElementsSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest {

    @Test
    public void BigDiffElementsTest() {
        loginSteps.assertBrowserTitle(properties.getProperty("homepage.title"));
        loginSteps.login(properties.getProperty("user.name"),properties.getProperty("user.password"));
        loginSteps.assertUsername(properties.getProperty("user.username").toUpperCase());
        DifferentElementsSteps differentElementsSteps = new DifferentElementsSteps(driver);
        differentElementsSteps.assertServiceHeader();
        differentElementsSteps.assertServiceLeft();
        differentElementsSteps.openDifferentElemsPage(properties.getProperty("diffelem.link"));
        differentElementsSteps.assertElemsOnPage();
        differentElementsSteps.assertRightSection();
        differentElementsSteps.assertLeftSection();
        List<String> checkboxesToSelect = Arrays.asList(properties.getProperty("diffelem.checktoselect").split("#"));
        differentElementsSteps.selectCheckboxes(checkboxesToSelect);
        differentElementsSteps.checkLogForCheckboxes(checkboxesToSelect,true);
        differentElementsSteps.selectRadio(properties.getProperty("diffelem.radio"));
        differentElementsSteps.checkLogForRadio(properties.getProperty("diffelem.radio"));
        differentElementsSteps.selectInDropdown(properties.getProperty("diffelem.select"));
        differentElementsSteps.checkLogForSelect(properties.getProperty("diffelem.select"));
        differentElementsSteps.unselectCheckboxes(checkboxesToSelect);
        differentElementsSteps.checkLogForCheckboxes(checkboxesToSelect,false);
    }


    // TODO I think this call is redundant here
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    // TODO I think this call is redundant here
    public void tearDown() {
        super.tearDown();
    }

}

