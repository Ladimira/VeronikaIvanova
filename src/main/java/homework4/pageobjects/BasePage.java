package homework4.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework4.enums.ServiceMenu;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class BasePage {
    private ElementsCollection mainMenu;
    private ElementsCollection serviceMenu;
    private ElementsCollection leftMenu;
    private ElementsCollection leftServiceMenu;

    public void BasePage() {
        mainMenu = $$(By.className("m-18"));
        serviceMenu = $$(By.className("dropdown-menu"));
        leftMenu = $$(By.className("sidebar-menu"));
        leftServiceMenu = $$(By.className("sub"));
    }

    public void login(String name, String password) {
        $(By.cssSelector("a[href=\"#\"]")).click();
        $(By.id("name")).setValue(name);
        $(By.id("password")).setValue(password);
        $(By.id("login-button")).click();
    }

    public void assertUsername(String username) {
        $(By.id("user-name")).shouldHave(Condition.text(username.toUpperCase()));
    }

    public void topMenuItemClick(String menuItemName) {
        mainMenu.findBy(Condition.text(menuItemName.toUpperCase())).click();
    }

    public void topServiceMenuItemClick(String menuItemName) {
        mainMenu.findBy(Condition.text("SERVICE")).click();
        serviceMenu.findBy(Condition.text(menuItemName.toUpperCase())).click();
    }

    public void leftMenuItemClick(String menuItemName) {
        leftMenu.findBy(Condition.text(menuItemName)).click();
    }

    public void leftServiceMenuItemClick(String menuItemName) {
        leftMenu.findBy(Condition.text("Service")).click();
        leftServiceMenu.findBy(Condition.text(menuItemName)).click();
    }

    public ElementsCollection getMainMenu() {
        return mainMenu;
    }

    public ElementsCollection getServiceMenu() {
        return serviceMenu;
    }

    public ElementsCollection getLeftMenu() {
        return leftMenu;
    }

    public ElementsCollection getLeftServiceMenu() {
        return leftServiceMenu;
    }
}
