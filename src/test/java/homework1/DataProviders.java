package homework1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // TODO What is the purpose of the current data provider?
    @DataProvider(name = "correct data")
    public static Object[][] correctData() {
        return new Object[][]{{1L, 2L, 1.0, 2.0}};
    }
    @DataProvider(name = "browserTitle")
    public static Object[][] browserTitle(){
        return new Object[][]{{"Home Page"}};
    }
}

