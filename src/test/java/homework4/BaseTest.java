package homework4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private Properties properties;

    @BeforeMethod
    public void setUp() {
        getProperties();
        Configuration.browser = "CHROME";
        Configuration.timeout = 4000;
        Configuration.startMaximized = true;
        open(properties.getProperty("homepage.link"));
    }


    @AfterMethod
    public void tearDown() {

    }

    public void getProperties(){
        properties = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream("src/test/resources/homework4/homework4.properties");
            properties.load(fis);
        }
        catch(IOException e){
        }
    }
}
