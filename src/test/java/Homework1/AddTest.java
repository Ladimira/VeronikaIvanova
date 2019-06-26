package Homework1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;

import static org.testng.Assert.assertEquals;

public class AddTest {
    // TODO could be extraced to the base class
    Calculator calculator;
    // TODO could be extraced to the base class

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }
    // TODO could be extraced to the base class

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void positiveNumbersTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(a, b), a + b);
        //test sum of doubles
        assertEquals(calculator.sum(c, d), c + d);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(-a, -b), -(a + b));
        //test sum of doubles
        assertEquals(calculator.sum(-c, -d), -(c + d));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void zeroTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(0, b), b);
        //test sum of doubles
        assertEquals(calculator.sum(0, d), d);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test sum of longs
        assertEquals(calculator.sum(a, -b), a - b);
        //test sum of doubles
        assertEquals(calculator.sum(c, -d), c - d);
    }
}
