package homework2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class UserLoginTest {
    protected WebDriver driver;

    // TODO Code duplication EX2 :extracted to superclass, done
    @BeforeMethod
    //1. Open test site by URL
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://epam.github.io/JDI/");
    }

    // TODO Code duplication EX2 :extracted to superclass, done
    @AfterMethod
    //17. Close browser
    public void tearDown() {
        driver.quit();
    }

    //2. Assert browser title
    // TODO Code duplication EX2 :extracted to superclass, done
    protected void assertBrowserTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle);
    }

    //3. Perform login
     // TODO Code duplication EX2 :extracted to superclass, done
    protected void performLogin(String login, String password) {
        // TODO Where should be setting implicitly waits???
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //click on dropdown arrow
         // TODO Why do you create this fields? : Skype discussed
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
    // TODO Code duplication EX2 :extracted to superclass, done
    protected void assertUsername(String username) {
        //assert username
        WebElement nameLabel = driver.findElement(By.id("user-name"));
        assertEquals(nameLabel.getText(),username);
    }
}
