package homework4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homework4.pageobjects.TableWithPagesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TableWithPagesSteps {
    private TableWithPagesPage tableWithPagesPage;

    public TableWithPagesSteps(){
        tableWithPagesPage = new TableWithPagesPage();
    }

    public void assertDefaultValue(){
        assertEquals(tableWithPagesPage.getDefaultSelectValue(),"5");
    }

    public void assertLeftSection(){
        assertTrue(tableWithPagesPage.getLeftSection().exists());
    }

    public void assertRightSection(){
        assertTrue(tableWithPagesPage.getRightSection().exists());
    }

    public void setSelectValue(String value){
        tableWithPagesPage.selectValueInDropdown(value);
    }

    public void checkLogAfterDropdown(String value){
        assertTrue(tableWithPagesPage.getLogRow("Datatable Events: length, new value="+value).exists());
    }

    public void assertTableRowCount(int count){
        assertEquals(tableWithPagesPage.getTableRowCount(),count);
    }

    public void checkSearch(String query){
        for(SelenideElement elem:tableWithPagesPage.search(query)){
            elem.shouldHave(Condition.text(query));
        }
    }
}
