// TODO package name should be in lower case : done
package homework3;

import homework3.steps.HomePageSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Exercise1 extends BaseTest {
    HomePageSteps homePageSteps;

    @Test
    public void BigLoginTest()
    {
        loginSteps.assertBrowserTitle(properties.getProperty("homepage.title"));
        loginSteps.login(properties.getProperty("user.name"),properties.getProperty("user.password"));
        loginSteps.assertUsername(properties.getProperty("user.username").toUpperCase());
        homePageSteps = new HomePageSteps(driver);
        homePageSteps.assertMenu();
        homePageSteps.assertImages();
        homePageSteps.assertImageTexts(Arrays.asList(properties.getProperty("main.imagetexts").split("#")));
        homePageSteps.assertMainHeader(properties.getProperty("main.maintitle"),properties.getProperty("main.jditext"));
        homePageSteps.assertIframe();
        homePageSteps.assertLogo();
        homePageSteps.assertSubHeader(properties.getProperty("main.subheader"));
        homePageSteps.assertSubHeaderIsLink("main.subheader.link");
        homePageSteps.assertLeftSection();
        homePageSteps.assertFooter();
    }

    @BeforeMethod
    //1. Open test site by URL
    public void setUp() {
        super.setUp();
    }

    @AfterMethod
    //19. Close browser
    public void tearDown() {
        super.tearDown();
    }



}
