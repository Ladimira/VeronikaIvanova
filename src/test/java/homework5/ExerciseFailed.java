package homework5;

import homework5.steps.DifferentElementsSteps;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
@Listeners(AllureAttachmentListener.class)
public class ExerciseFailed extends BaseTest {

    @Test(testName = "Big different elements page test")
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

}

