package at.campus02.swe.logic;

import org.junit.Test;
import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

import static org.junit.Assert.*;


public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }


    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }

    @Test
    public void testModulo() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        //verify
        assertEquals(2, result, 0);
    }

    @Test
    public void testModulo2() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(5.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        //verify
        assertEquals(2, result, 0);
    }

    @Test
    public void testModuloByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }
    }

    @Test
    public void testSin90Degrees() throws CalculatorException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(90.0);
        calc.push(90.0);

        double result = calc.perform(Operation.sin);
        assertEquals(1, result, 0);
    }

    @Test
    public void testCos0Degrees() throws CalculatorException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(0.0);
        calc.push(0.0);

        double result = calc.perform(Operation.cos);
        assertEquals(1, result, 0);
    }

    @Test
    public void testCos180Degrees() throws CalculatorException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(180.0);
        calc.push(180.0);

        double result = calc.perform(Operation.cos);
        assertEquals(-1, result, 0);
    }

    @Test
    public void testrandom1() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(5);
        calc.push(3);
        double result = calc.perform(Operation.random);

        //verify
        assertTrue(result == 3 || result == 4 || result == 5);

    }

    @Test
    public void testDotProductVectorLength2() throws CalculatorException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(1); // Vektor a
        calc.push(3); // Vektor a
        calc.push(2); // Vektor b
        calc.push(4); // Vektor b

        calc.push(2.0); // Anzahl der Elemente

        double result = calc.perform(Operation.dotproduct);
        assertEquals(14, result, 0);
    }

    @Test
    public void testDotProductVectorLength3() throws CalculatorException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(1); // Vektor a
        calc.push(3); // Vektor a
        calc.push(1); // Vektor a
        calc.push(2); // Vektor b
        calc.push(4); // Vektor b
        calc.push(4); // Vektor b

        calc.push(3.0); // Anzahl der Elemente

        double result = calc.perform(Operation.dotproduct);
        assertEquals(18, result, 0);
    }

    @Test
    public void testDotProductNegativeTest() throws CalculatorException, NegativeArraySizeException{
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.push(1); // Vektor a
        calc.push(3); // Vektor a
        calc.push(2); // Vektor b
        calc.push(4); // Vektor b

        calc.push(-2); // Anzahl der Elemente

        try{
            calc.perform(Operation.dotproduct);
            fail("Expection expected");
        } catch (NegativeArraySizeException e){
            assertEquals("Wrong Entry, Vektor must be grater than 0",e.getMessage());
        }
    }



}