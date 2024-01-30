package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();
    private Double tmp;

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b;
        double a;
        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case mod:
                b = pop();
                a = pop();
                if (b == 0)
                    throw new CalculatorException("Division by zero");
                return a % b;
            case sin:
                a = pop();
               return Math.sin(Math.toRadians(a));
            case cos:
                a = pop();
                return Math.cos(Math.toRadians(a));
            case random:
                b = pop();
                a = pop();
                return (int) ((Math.random() * (a - b)) + b);
            case dotproduct:
                int amount = (int) pop();
                if (amount <= 0 )
                    throw new NegativeArraySizeException ("Wrong Entry, Vektor must be grater than 0");

                double result = 0;
                double[] vectorA = new double[amount];
                double[] vectorB = new double[amount];
                for (int i = 0; i  < amount; i++) {
                    vectorA[i] = pop();
                }
                for (int i = 0; i  < amount; i++) {
                    vectorB[i] = pop();
                }
                for (int i = 0; i < amount; i++) {
                    result += vectorA[i]*vectorB[i];
                }
                return result;
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void store(double result) throws CalculatorException {
        tmp = result;
    }

    @Override
    public double load() throws CalculatorException {
        if(tmp == null)
            throw new CalculatorException("Fehler CalcImpl");
        return tmp;
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
