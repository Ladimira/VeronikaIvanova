package Homework2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void gerUrlTest() {
        driver.get("https://epam.github.io/JDI/");
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test (dataProvider = "credentials")
    public void loginTest(String login, String password, String username) {
        WebElement dropDownButton = driver.findElement(By.className("dropdown-toggle"));
        dropDownButton.click();
        WebElement loginBox = driver.findElement(By.id("name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement nameLabel = driver.findElement(By.id("user-name"));
        assertEquals(nameLabel.getText(),username);

    }
}
