package homework4.steps;

import homework4.pageobjects.MetalsColorsPage;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class MetalsColorsSteps {
    MetalsColorsPage metalsColorsPage;

    public void fillForm(String summaryRadio1, String summaryRadio2, String color, String metal,
                         List<String> elements, List<String> vegetables) {
        if (summaryRadio1 != null)
            metalsColorsPage.setRadios(summaryRadio1, summaryRadio2);
        if (color != null)
            metalsColorsPage.selectColor(color);
        if (metal != null)
            metalsColorsPage.selectMetal(metal);
        if (vegetables != null)
            metalsColorsPage.selectVegetables(vegetables);
        if (elements != null)
            metalsColorsPage.setCheckboxes(elements);
        metalsColorsPage.clickSubmit();
    }

    public void assertResult(String summaryRadio1, String summaryRadio2, String color, String metal,
                             List<String> elements, List<String> vegetables) {
        //get results
        List<String> results = metalsColorsPage.getResults().texts();
        //assert result size
        assertEquals(results.size(), 5);
        //assert radiobutton result
        int sum = parseInt(summaryRadio1) + parseInt(summaryRadio2);
        assertTrue(results.get(0).contains(Integer.toString(sum)));
        //assert elements
        for (String elem : elements)
            assertTrue(results.get(1).contains(elem));
        //assert color
        assertTrue(results.get(2).contains(color));
        //assert metal
        assertTrue(results.get(3).contains(metal));
        //assert vegetables
        for (String elem : vegetables)
            assertTrue(results.get(4).contains(elem));

    }
}
