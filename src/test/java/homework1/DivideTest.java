package homework1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest {
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
        //test div of longs
        assertEquals(calculator.div(b, a), b / a);
        //test div of doubles
        assertEquals(calculator.div(d, c), d / c);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void negativeNumbersTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(-b, -a), b / a);
        //test div of doubles
        assertEquals(calculator.div(-d, -c), d / c);
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void differentSignNumbersTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(-b, a), -b / a);
        //test div of doubles
        assertEquals(calculator.div(-d, c), -d / c);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct data")
    // TODO IMHO it will be better to split this test to the two
    public void partialResultTest(long a, long b, double c, double d) {
        //test div of longs
        assertEquals(calculator.div(a, b), a / b);
        //test div of doubles
        assertEquals(calculator.div(c, d), c / d);
    }
}
