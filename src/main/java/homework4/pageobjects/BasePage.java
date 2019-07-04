package homework4.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;


public class BasePage {
    private ElementsCollection mainMenu;
    private ElementsCollection serviceMenu;
    private ElementsCollection leftMenu;
    private ElementsCollection leftServiceMenu;

    public BasePage() {

        mainMenu = $(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8")).findAll(By.tagName("li"));
        serviceMenu = $(By.className("dropdown-menu")).findAll(By.tagName("li"));
        leftMenu = $(By.className("sidebar-menu")).findAll(By.tagName("li"));
        leftServiceMenu = $(By.className("sub")).findAll(By.tagName("li"));
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


    public ElementsCollection getServiceMenu() {
        return serviceMenu;
    }

    public ElementsCollection getLeftServiceMenu() {
        return leftServiceMenu;
    }

    public void logout(){
        $(By.cssSelector("a[href=\"#\"]")).click();
        $(By.cssSelector("div.logout>button")).click();
    }
}
