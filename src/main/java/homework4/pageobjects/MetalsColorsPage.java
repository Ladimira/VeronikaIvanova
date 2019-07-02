package homework4.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MetalsColorsPage {
    public void clickSubmit() {
        $(By.id("submit-button")).click();
    }

    public ElementsCollection getResults() {
        return $$(By.cssSelector("ul.results>li"));
    }

    public void setCheckboxes(List<String> checkboxes) {
        ElementsCollection elementsList = $(By.id("elements-checklist")).findAll(By.tagName("p"));
        for (SelenideElement elem : elementsList) {
            if (checkboxes.contains(elem.getText())) {
                elem.click();
            }
        }
    }

    public void selectVegetables(List<String> vegetables) {
        ElementsCollection vegetablesList = $(By.id("salad-dropdown")).find(By.className("dropdown-menu")).findAll(By.tagName("li"));
        for (SelenideElement elem : vegetablesList) {
            if (vegetables.contains(elem.getText())) {
                elem.click();
            }
        }
    }

    public void setRadios(String radio1, String radio2) {
        for (SelenideElement elem : $$(By.className("radio"))) {
            if (elem.getText().contains(radio1) || elem.getText().contains(radio2))
                elem.click();
        }
    }

    public void selectMetal(String metal) {
        $(By.cssSelector("select.selectpicker")).setValue(metal);
    }

    public void selectColor(String color) {
        $(By.cssSelector("button.btn-default")).setValue(color);
    }
}
