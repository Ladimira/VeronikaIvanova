package homework3.steps;

import homework3.voids.BasePage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private BasePage basePage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    public void login(String login, String password) {
        basePage = new BasePage(driver);
        basePage.Login(login, password);
    }

    public void assertUsername(String username) {
        assertEquals(basePage.nameLabel.getText(), username);
    }
}
