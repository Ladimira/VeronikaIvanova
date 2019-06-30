package homework2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserLoginTest {
    protected WebDriver driver;

    @BeforeMethod
    //1. Open test site by URL
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://epam.github.io/JDI/");
    }

    @AfterMethod
    //17. Close browser
    public void tearDown() {
        driver.quit();
    }

    //2. Assert browser title
    protected void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    //3. Perform login
    protected void performLogin(String login, String password) {
        WebElement dropDownButton = driver.findElement(By.cssSelector("a[href=\"#\"]"));
        dropDownButton.click();
        //enter login and password
        WebElement loginBox = driver.findElement(By.id("name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        //click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    //4. Assert username
    protected void assertUsername(String username) {
        //assert username
        WebElement nameLabel = driver.findElement(By.id("user-name"));
        assertEquals(nameLabel.getText(),username);
    }

    //support method for element assertion
    public void assertElemFromDriver(By by) {
        try {
            WebElement elem = driver.findElement(by);
            assertTrue(elem.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    //support method for element list assertion
    public void assertElementWithText(WebElement element,String elementText){
            //Check if element is displayed
            assertTrue(element.isDisplayed());
            //check element text
            assertEquals(element.getText(),elementText);

    }
}
