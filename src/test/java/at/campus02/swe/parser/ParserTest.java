package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserModulo() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/testmod.xml"));

        verify(cal).push(2.0);
        verify(cal).push(3.0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserModulo2() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/testmod2.xml"));

        verify(cal).push(5.0);
        verify(cal).push(3.0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserModuloNeg() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/testmodneg.xml"));

        verify(cal).push(5.0);
        verify(cal).push(0);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserSin() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/sin01-test.xml"));

        verify(cal).push(90.0);
        verify(cal).perform(Operation.sin);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserCos() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/cos01-test.xml"));

        verify(cal).push(180.0);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);
    }



}