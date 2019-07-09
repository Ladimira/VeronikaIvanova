package homework6.steps;

import cucumber.api.java.en.When;
import homework6.enums.MainMenu;
import homework6.enums.ServiceMenu;
import homework6.hooks.TestContext;
import homework6.pageobjects.BasePage;
import homework6.pageobjects.DifferentElementsPage;
import homework6.pageobjects.UserTablePage;

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

    @When("I login as user \"Piter Chailovskii\"")
    public void loginAsPiter(){
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.login("epam","1234");
    }

    @When("I click on \"Service\" button in Header")
    public void iClickServiceMenuButton() {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.menuItemClick("SERVICE");
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void iClickUserTableMenuButton() {
        BasePage basePage = new BasePage(TestContext.getDriver());
        basePage.menuItemClick("SERVICE");
        basePage.serviceMenuItemClick("USER TABLE");
    }

    @When("I select 'vip' checkbox for \".*\"")
    public void selectVipCheckbox(String userName){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        userTablePage.selectCheckByUserName(userName);
    }

    @When("I click on dropdown in column Type for user .*")
    public void clickOnDropdownForUser(String userName){
        UserTablePage userTablePage = new UserTablePage(TestContext.getDriver());
        userTablePage.clickDropdownByUserName(userName);
    }
}
