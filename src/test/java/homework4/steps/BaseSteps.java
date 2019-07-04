package homework4.steps;


import com.codeborne.selenide.CollectionCondition;
import homework4.enums.ServiceMenu;
import homework4.pageobjects.BasePage;

import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class BaseSteps {
    BasePage basePage;

    public BaseSteps() {
        basePage = new BasePage();
    }

    public void assertBrowserTitle(String title) {
        assertEquals(title(), title);
    }

    public void login(String login, String password) {
        basePage.login(login, password);
    }

    public void assertUsername(String username) {
        basePage.assertUsername(username);
    }

    public void assertServiceMenus() {
        assertEquals(basePage.getLeftServiceMenu().size(), 6);
        assertEquals(basePage.getServiceMenu().size(), 6);
        basePage.getLeftServiceMenu().shouldHave(CollectionCondition.texts(ServiceMenu.values().toString()));
        basePage.getServiceMenu().shouldHave(CollectionCondition.texts(ServiceMenu.values().toString()));
    }

    public void clickTopMenuItem(String itemName) {
        basePage.topMenuItemClick(itemName);
    }

    public void clickServiceTopMenuItem(String itemName) {
        basePage.topServiceMenuItemClick(itemName);
    }

    public void clickLeftMenuItem(String itemName) {
        basePage.leftMenuItemClick(itemName);
    }

    public void logout() {
        basePage.logout();
    }

}
