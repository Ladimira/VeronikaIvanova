package homework4.steps;

import homework4.pageobjects.MetalsColorsPage;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class MetalsColorsSteps {
    MetalsColorsPage metalsColorsPage;

    public MetalsColorsSteps() {
        metalsColorsPage = new MetalsColorsPage();
    }

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
        int resultCount=0;
        if (summaryRadio1 != null) {
            //assert radiobutton result
            int sum = parseInt(summaryRadio1) + parseInt(summaryRadio2);
            assertTrue(results.get(resultCount).contains(Integer.toString(sum)));
            resultCount++;
        } else {
            assertTrue(results.get(resultCount).contains("3"));
            resultCount++;
        }
        if (elements != null) {
            //assert elements
            for (String elem : elements)
                assertTrue(results.get(1).contains(elem));
            resultCount++;
        }
        if (color != null) {
            //assert color
            assertTrue(results.get(resultCount).contains(color));
            resultCount++;
        }
        else{
            assertTrue(results.get(resultCount).contains("Colors"));
            resultCount++;
        }
        if (metal != null) {
            //assert metal
            assertTrue(results.get(resultCount).contains(metal));
            resultCount++;
        }
        else {
            assertTrue(results.get(resultCount).contains("Metals"));
            resultCount++;
        }
        if (vegetables != null) {
            //assert vegetables
            for (String elem : vegetables)
                assertTrue(results.get(resultCount).contains(elem));
            resultCount++;
        }
        else {
            assertTrue(results.get(resultCount).contains("Vegetables"));
            resultCount++;
        }
        //assert result size
        assertEquals(results.size(), resultCount);

    }
}
