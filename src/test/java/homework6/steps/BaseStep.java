package homework6.steps;

import homework6.pageobjects.BasePage;
import homework6.hooks.TestContext;

public abstract class BaseStep {

    protected BasePage basePage;

    public BaseStep() {
        basePage = basePage.getInstance(TestContext.getDriver());
    }

}
