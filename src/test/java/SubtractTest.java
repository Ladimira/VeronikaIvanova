import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
// TODO Same comments as for AddTest class
public class SubtractTest {
    Calculator calculator;
    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void positiveNumbersTest(long a, long b,double c, double d){
        assertEquals(a-b,calculator.sub(a,b));
        assertEquals(c-d,calculator.sub(c,d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b,double c, double d){
        assertEquals(b-a,calculator.sub(-a,-b));
        assertEquals(d-c,calculator.sub(-c,-d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void zeroTest(long a, long b,double c, double d){
        assertEquals(-b,calculator.sub(0,b));
        assertEquals(-d,calculator.sub(0,d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b,double c, double d){
        assertEquals(a+b,calculator.sub(a,-b));
        assertEquals(c+d,calculator.sub(c,-d));
    }
}
