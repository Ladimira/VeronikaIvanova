package homework1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest {
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

    @Test(dataProviderClass = homework1.DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void positiveNumbersTest(long a, long b, double c, double d) {
        //test sub of longs
        assertEquals(calculator.sub(a, b), a - b);
        //test sub of doubles
        assertEquals(calculator.sub(c, d), c - d);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test sub of longs
        assertEquals(calculator.sub(a, b), b - a);
        //test sub of doubles
        assertEquals(calculator.sub(c, d), d - c);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void zeroTest(long a, long b, double c, double d) {
        //test sub of longs
        assertEquals(calculator.sub(0, b), - b);
        //test sub of doubles
        assertEquals(calculator.sub(0, d), - d);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test sub of longs
        assertEquals(calculator.sub(a, -b), a + b);
        //test sub of doubles
        assertEquals(calculator.sub(c, -d), c + d);
    }
}
