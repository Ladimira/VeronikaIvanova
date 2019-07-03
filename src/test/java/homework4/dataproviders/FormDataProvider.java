package homework4.dataproviders;

import homework4.builders.FormDataBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;


public class FormDataProvider {
    @DataProvider(name = "Form Data")
    public static Object[][] formData() {
        // TODO Does not compile!
        return new Object[][]{
                {FormDataBuilder.builder().
                    radio1(null).
                    radio2(null).
                    elements(Arrays.asList("Earth")).
                    color("Yellow").
                    metal("Gold").
                    vegetables(null).
                    build()},
                {FormDataBuilder.builder().
                        radio1("3").
                        radio2("8").
                        elements(null).
                        color(null).
                        metal(null).
                        vegetables(Arrays.asList("Cucumber", "Tomato")).
                        build()},
                {FormDataBuilder.builder().
                        radio1("3").
                        radio2("2").
                        elements(Arrays.asList("Wind", "Fire", "Water")).
                        color(null).
                        metal("Bronze").
                        vegetables(Arrays.asList("Onion")).
                        build()},
                {FormDataBuilder.builder().
                        radio1("6").
                        radio2("5").
                        elements(Arrays.asList("Water")).
                        color("Green").
                        metal("Selen").
                        vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).
                        build()},
                {FormDataBuilder.builder().
                        radio1(null).
                        radio2(null).
                        elements(Arrays.asList("Fire")).
                        color("Blue").
                        metal(null).
                        vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).
                        build()}
        };
    }
}
