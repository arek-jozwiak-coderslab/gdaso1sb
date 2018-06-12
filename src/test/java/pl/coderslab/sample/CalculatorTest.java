package pl.coderslab.sample;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static final int ELEMENT_1 = 1;
    private static final int ELEMENT_2 = 2;
    private static final int RESULT_ADD = 3;
    private static final int RESULT_MULTIPLY = 2;

    @Test
    public void add() throws Exception {
        Calculator c = new Calculator();
        int result = c.add(ELEMENT_1, ELEMENT_2);
        assertEquals(RESULT_ADD, result);
    }

    @Test
    public void multiply() throws Exception {
        Calculator c = new Calculator();
        int result = c.multiply(ELEMENT_1, ELEMENT_2);
        assertEquals(RESULT_MULTIPLY, result);
    }

}