package homework5;

import homework5.steps.HomePageSteps;
import org.testng.annotations.Test;

import java.util.Arrays;



public class ExercisePassed extends BaseTest {
    HomePageSteps homePageSteps;

    @Test(testName = "Big login & home page test - failed")
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
        homePageSteps.assertSubHeaderIsLink(properties.getProperty("main.subheader.link"));
        homePageSteps.assertLeftSection();
        homePageSteps.assertFooter();
    }

}
