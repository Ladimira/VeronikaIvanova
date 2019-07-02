package homework4.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableWithPagesPage {


    public SelenideElement getRightSection(){
        return $(By.name("log-sidebar"));
    }

    public SelenideElement getLeftSection(){
        return $(By.name("navigation-sidebar"));
    }

    public String getDefaultSelectValue(){
        return $(By.name("table-with-pages_length")).getSelectedValue();
    }

    public void selectValueInDropdown(String value){
        $(By.name("table-with-pages_length")).setValue(value);
    }

    public SelenideElement getLogRow(String text){
        return $$(By.cssSelector("ul.logs>li")).findBy(Condition.text(text));
    }

    public int getTableRowCount(){
        return $(By.id("table-with-pages")).findAll(By.tagName("tr")).size();
    }
    public ElementsCollection search(String query){
        $(By.cssSelector("input[type=\"search\"]")).setValue(query);
        return $(By.id("table-with-pages")).findAll(By.tagName("tr"));
    }

}
