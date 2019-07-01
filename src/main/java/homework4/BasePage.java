package homework4;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;


public class BasePage {
   public void assertPageTitle(String pageTitle){

   }

   public void login(String name, String password){

   }

   public void assertUsername(String username){
        $(By.id("user-name")).shouldHave(Condition.text(username.toUpperCase()));
   }

   public void topMenuItemClick(String menuItemName){
        $$(By.className("m-18")).findBy(Condition.text(menuItemName.toUpperCase())).click();
    }

    public void topServiceMenuItemClick(String menuItemName){
        $$(By.className("m-18")).findBy(Condition.text("SERVICE")).click();
        $$(By.className("dropdown-menu")).findBy(Condition.text(menuItemName.toUpperCase())).click();
    }
    public void leftMenuItemClick(String menuItemName){
        $$(By.className("sidebar-menu")).findBy(Condition.text(menuItemName)).click();
    }
    public void leftServiceMenuItemClick(String menuItemName){
        $$(By.className("sidebar-menu")).findBy(Condition.text("Service")).click();
        $$(By.className("sub")).findBy(Condition.text(menuItemName)).click();
    }
}
