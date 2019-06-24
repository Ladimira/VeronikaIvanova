package Homework1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest {
    Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void positiveNumbersTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(b, a), b / a);
        //test div of doubles
        assertEquals(calculator.div(d, c), d / c);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(-b, -a), b / a);
        //test div of doubles
        assertEquals(calculator.div(-d, -c), d / c);
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(-b, a), -b / a);
        //test div of doubles
        assertEquals(calculator.div(-d, c), -d / c);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void partialResultTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(a, b), a / b);
        //test div of doubles
        assertEquals(calculator.div(c, d), c / d);
    }
}
