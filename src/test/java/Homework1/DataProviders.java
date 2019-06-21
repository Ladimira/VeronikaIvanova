package Homework1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "correct data")
    public static Object[][] correctData()
    {        return new Object[][]{{1L, 2L, 1.0, 2.0}};
    }
}

