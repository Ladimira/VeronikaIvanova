package Homework1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest {
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
        //test mult of longs
        assertEquals(calculator.mult(a, b), a * b);
        //test mult of doubles
        assertEquals(calculator.mult(c, d), c * d);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test mult of longs
        assertEquals(calculator.mult(-a, -b), a * b);
        //test mult of doubles
        assertEquals(calculator.mult(-c, -d), c * d);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void zeroTest(long a, long b, double c, double d) {
        //test mult of longs
        assertEquals(calculator.mult(0L, b), 0L);
        //test mult of doubles
        assertEquals(calculator.mult(0.0, d), 0.0);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test mult of longs
        assertEquals(calculator.mult(-a, b), -a * b);
        //test mult of doubles
        assertEquals(calculator.mult(-c, d), -c * d);
    }
}
