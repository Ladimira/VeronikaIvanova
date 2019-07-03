package homework4.dataproviders;

import homework4.builder.FormDataBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;


public class FormDataProvider {
    @DataProvider(name = "Form Data")
    public static Object[][] formData() {
        // TODO Does not compile! : done
        return new Object[][]{
                {FormDataBuilder.builder().
                    summaryRadio1(null).
                    summaryRadio2(null).
                    elements(Arrays.asList("Earth")).
                    color("Yellow").
                    metal("Gold").
                    vegetables(null).
                    build()},
                {FormDataBuilder.builder().
                        summaryRadio1("3").
                        summaryRadio2("8").
                        elements(null).
                        color(null).
                        metal(null).
                        vegetables(Arrays.asList("Cucumber", "Tomato")).
                        build()},
                {FormDataBuilder.builder().
                        summaryRadio1("3").
                        summaryRadio2("2").
                        elements(Arrays.asList("Wind", "Fire", "Water")).
                        color(null).
                        metal("Bronze").
                        vegetables(Arrays.asList("Onion")).
                        build()},
                {FormDataBuilder.builder().
                        summaryRadio1("6").
                        summaryRadio2("5").
                        elements(Arrays.asList("Water")).
                        color("Green").
                        metal("Selen").
                        vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).
                        build()},
                {FormDataBuilder.builder().
                        summaryRadio1(null).
                        summaryRadio2(null).
                        elements(Arrays.asList("Fire")).
                        color("Blue").
                        metal(null).
                        vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).
                        build()}
        };
    }
}
