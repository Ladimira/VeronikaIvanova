package homework5.steps;

import homework5.TestProvider;
import homework5.voids.BasePage;
import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private BasePage basePage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        TestProvider.getInstance().setDriver(driver);
    }

    @Step("Check browser title")
    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    @Step("Login as user")
    public void login(String login, String password) {
        basePage = new BasePage(driver);
        basePage.login(login, password);

    }

    public void assertUsername(String username) {
        assertEquals(basePage.getNameLabel().getText(), username);
    }
}
