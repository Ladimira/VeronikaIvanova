package homework4;


import homework4.builders.FormDataBuilder;
import homework4.dataproviders.FormDataProvider;
import homework4.steps.MetalsColorsSteps;
import org.testng.annotations.Test;


public class Exercise2 extends BaseTest {
    @Test(dataProviderClass = FormDataProvider.class, dataProvider = "Form Data")
    public void MetalsColorsTest(FormDataBuilder formDataBuilder) {
        baseSteps.assertBrowserTitle(properties.getProperty("homepage.title"));
        baseSteps.login(properties.getProperty("user.name"), properties.getProperty("user.password"));
                baseSteps.assertUsername(properties.getProperty("user.username").toUpperCase());
        baseSteps.clickTopMenuItem(properties.getProperty("metalscolors.menu"));
        MetalsColorsSteps metalsColorsSteps = new MetalsColorsSteps();
        metalsColorsSteps.fillForm(formDataBuilder.summaryRadio1, formDataBuilder.summaryRadio2, formDataBuilder.color, formDataBuilder.metal,
                formDataBuilder.elements, formDataBuilder.vegetables);
        metalsColorsSteps.assertResult(formDataBuilder.summaryRadio1, formDataBuilder.summaryRadio2, formDataBuilder.color, formDataBuilder.metal,
                formDataBuilder.elements, formDataBuilder.vegetables);
    }
}
