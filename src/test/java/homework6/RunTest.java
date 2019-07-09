package homework6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:homework6"},
        glue = {"classpath:homework6"},
        tags = {"@runExercise1","@runExercise2"}
)
public class RunTest extends AbstractTestNGCucumberTests {


}
