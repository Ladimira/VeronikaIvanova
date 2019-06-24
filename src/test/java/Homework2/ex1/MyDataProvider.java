package Homework2.ex1;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
    @DataProvider(name = "credentials")
    public static Object[][] credentials() {
        return new Object[][]{{"epam","1234","PITER CHAILOVSKII"}};
    }

}
