import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
// TODO Same comments as for AddTest class
public class MultiplyTest {
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
        assertEquals(a*b,calculator.mult(a,b));
        assertEquals(c*d,calculator.mult(c,d));

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b,double c, double d){
        assertEquals(a*b,calculator.mult(-a,-b));
        assertEquals(c*d,calculator.mult(-c,-d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void zeroTest(long a, long b,double c, double d){
        assertEquals(0L,calculator.mult(0,b));
        assertEquals(0.0,calculator.mult(0,d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b,double c, double d){
        assertEquals(-a*b,calculator.mult(a,-b));
        assertEquals(-c*d,calculator.mult(c,-d));
    }
}
