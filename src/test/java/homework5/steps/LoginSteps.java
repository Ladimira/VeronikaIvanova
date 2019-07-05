package homework5.steps;

import homework3.voids.BasePage;
import homework5.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private BasePage basePage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check browser title")
    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @Step("Login as user")
    public void login(String login, String password) {
        basePage = new BasePage(driver);
        basePage.login(login, password);
        TestProvider.getInstance().setDriver(driver);
    }

    public void assertUsername(String username) {
        assertEquals(basePage.getNameLabel().getText(), username);
    }
}
