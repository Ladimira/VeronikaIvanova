// TODO Where should located all test code?
// TODO What is the package name should be?
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// TODO Import not found
import com.epam.tat.module4.Calculator;

// TODO Why is it AssertJUnit?
import static org.testng.AssertJUnit.assertEquals;

public class AddTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO Why is it having 4 input parameters
    public void positiveNumbersTest(long a, long b,double c, double d){
        // TODO Why are there 2 asserts
        assertEquals(a+b,calculator.sum(a,b));
        assertEquals(c+d,calculator.sum(c,d));

    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO Why is it having 4 input parameters
    public void negativeNumbersTest(long a, long b,double c, double d){
        // TODO Why are there 2 asserts
        assertEquals(-(a+b),calculator.sum(-a,-b));
        assertEquals(-(c+d),calculator.sum(-c,-d));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO Why is it having 4 input parameters
    public void zeroTest(long a, long b,double c, double d){
        // TODO Why are there 2 asserts
        assertEquals(b,calculator.sum(0,b));
        assertEquals(d,calculator.sum(0,d));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO Why is it having 4 input parameters
    public void differentSignNumbersTest(long a, long b,double c, double d){
        // TODO Why are there 2 asserts
        assertEquals(a-b,calculator.sum(a,-b));
        assertEquals(c-d,calculator.sum(c,-d));
    }
}
