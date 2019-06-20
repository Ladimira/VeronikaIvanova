import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "correct data")
    public static Object[][] correctData()
    {        return new Object[][]{{1, "Admin"}, {2, "User"}};
    }
}

