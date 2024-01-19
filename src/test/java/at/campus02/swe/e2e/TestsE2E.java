package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

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

}
