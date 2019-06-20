import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;

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
    public void positiveNumbersTest(long a, long b,double c, double d){
        assertEquals(a+b,calculator.sum(a,b));
        assertEquals(c+d,calculator.sum(c,d));

    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b,double c, double d){
        assertEquals(-(a+b),calculator.sum(-a,-b));
        assertEquals(-(c+d),calculator.sum(-c,-d));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void zeroTest(long a, long b,double c, double d){
        assertEquals(b,calculator.sum(0,b));
        assertEquals(d,calculator.sum(0,d));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b,double c, double d){
        assertEquals(a-b,calculator.sum(a,-b));
        assertEquals(c-d,calculator.sum(c,-d));
    }
}
