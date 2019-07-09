package homework6.steps;

import cucumber.api.java.en.Given;
import homework6.hooks.TestContext;

public class GivenSteps extends BaseStep {

    @Given("I am on the JDI Index Page")
    public void iAmOnTheJdiIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

}
