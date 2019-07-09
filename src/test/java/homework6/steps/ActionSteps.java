package homework6.steps;

import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import homework6.enums.MainMenu;
import homework6.enums.ServiceMenu;
import homework6.hooks.TestContext;
import homework6.voids.BasePage;
import homework6.voids.DifferentElementsPage;

import java.util.List;

public class ActionSteps extends BaseStep {

    @When("I login as")
    public void iLoginAs(List<String> credentials) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.login(credentials.get(0), credentials.get(1));
    }

    @When("I click '(Service)' top menu button")
    public void iClickHeaderMenuButton(MainMenu menuItem) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.menuItemClick(menuItem.getName().toUpperCase());
    }

    @When("I click '(Service)' left menu button")
    public void iClickLeftMenuButton(MainMenu menuItem) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.menuItemClick(menuItem.getName());
    }

    @When("I click '(Different Elements)' dropdown menu button")
    public void iClickTopServiceMenuButton(ServiceMenu menuItem) {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.serviceMenuItemClick(menuItem.getName().toUpperCase());
    }

    @When("I click on checkboxes")
    public void clickCheckboxes(List<String> checkboxes) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        for (String checkbox : checkboxes) {
            differentElementsPage.findCheckboxByName(checkbox).click();
        }
    }

    @When("I click on radiobutton '.*'")
    public void clickRadio(String radiobutton) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        differentElementsPage.findRadioByName(radiobutton).click();
    }

    @When("I select in dropdown '.*'")
    public void selectValue(String value) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext.getDriver());
        differentElementsPage.getColorsSelect().selectByValue(value);
    }
}
