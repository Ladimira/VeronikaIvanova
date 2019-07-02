package homework4;

import homework4.enums.ServiceMenu;
import homework4.steps.TableWithPagesSteps;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class Exercise1 extends BaseTest {
    @Test
    public void TableWithPagesTest(){
        baseSteps.assertBrowserTitle(properties.getProperty("homepage.title"));
        baseSteps.login(properties.getProperty("user.name"),properties.getProperty("user.password"));
        baseSteps.assertUsername(properties.getProperty("user.username").toUpperCase());
        baseSteps.clickLeftMenuItem(properties.getProperty("service.menu"));
        baseSteps.clickTopMenuItem(properties.getProperty("service.menu"));
        baseSteps.assertServiceMenus();
        baseSteps.clickServiceTopMenuItem(ServiceMenu.TABLE_WITH_PAGES.name());
        TableWithPagesSteps tableWithPagesSteps = new TableWithPagesSteps();
        tableWithPagesSteps.assertDefaultValue();
        tableWithPagesSteps.assertLeftSection();
        tableWithPagesSteps.assertRightSection();
        tableWithPagesSteps.setSelectValue(properties.getProperty("pagesselect.value"));
        tableWithPagesSteps.checkLogAfterDropdown(properties.getProperty("pagesselect.value"));
        tableWithPagesSteps.assertTableRowCount(parseInt(properties.getProperty("pagesselect.value")));
        tableWithPagesSteps.checkSearch(properties.getProperty("querytext"));
    }
}
