import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DivideTest {
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
        assertEquals(b/a,calculator.div(b,a));
        assertEquals(d/c,calculator.div(d,c));

    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b,double c, double d){
        assertEquals(b/a,calculator.div(-b,-a));
        assertEquals(d/c,calculator.div(-d,-c));
    }


    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b,double c, double d){
        assertEquals(-b/a,calculator.div(-b,a));
        assertEquals(-d/c,calculator.div(-d,c));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void partialResultTest(long a, long b,double c, double d){
        assertEquals(a/b,calculator.div(a,b));
        assertEquals(c/d,calculator.div(c,d));
    }
}
