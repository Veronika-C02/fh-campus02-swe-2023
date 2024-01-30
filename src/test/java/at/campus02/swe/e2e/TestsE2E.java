package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class TestsE2E {

    @Test
    public void e2eTestAdditionSubtraction() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-test01.xml"));

        Assert.assertEquals(-6.0,result,0);

    }

    @Test
    public void e2eTestAdditionMultiplicationDivision() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-test02.xml"));

        Assert.assertEquals(2.0,result,0);

    }

    @Test
    public void e2eTestAdditionOfSin90AndCos0() throws Exception {

        Calculator cal = new CalculatorImpl();
        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-test03.xml"));

        Assert.assertEquals(2.0,result,0);

    }

    @Test
    public void e2eTestSubtractionOfSin90AndCos0() throws Exception {

        Calculator cal = new CalculatorImpl();
        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-test04.xml"));

        Assert.assertEquals(0.0,result,0);

    }

    @Test
    public void e2eTestrandom() throws Exception {

        Calculator cal = new CalculatorImpl();
        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-test05.xml"));

        assertTrue(result == 1 || result == 2 || result == 3);

    }

    @Test
    public void e2eTestStoreandLoad() throws Exception {

        Calculator cal = new CalculatorImpl();
        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/e2e-store-load-test01.xml"));

        Assert.assertEquals(9.0,result,0);

    }


}
