package homework5;

import homework5.steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver driver;
    protected LoginSteps loginSteps;
    protected Properties properties;

    @BeforeMethod
    //1. Open test site by URL
    public void setUp() {
        getProperties();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.path"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(properties.getProperty("homepage.link"));
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod
    //17. Close browser
    public void tearDown() {
        driver.quit();
    }

    public void getProperties(){
        properties = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream("src/test/resources/homework5/homework5.properties");
            properties.load(fis);
        }
        catch(IOException e){
        }
    }

}
