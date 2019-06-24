package Homework1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;

import static org.testng.Assert.assertEquals;

public class AddTest {
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
        //test sum of longs
        assertEquals(calculator.sum(a, b), a + b);
        //test sum of doubles
        assertEquals(calculator.sum(c, d), c + d);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(-a, -b), -(a + b));
        //test sum of doubles
        assertEquals(calculator.sum(-c, -d), -(c + d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void zeroTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(0, b), b);
        //test sum of doubles
        assertEquals(calculator.sum(0, d), d);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(a, -b), a - b);
        //test sum of doubles
        assertEquals(calculator.sum(c, -d), c - d);
    }
}
