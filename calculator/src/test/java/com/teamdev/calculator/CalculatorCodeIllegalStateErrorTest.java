package com.teamdev.calculator;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * @author vladislav.kovchug
 */
public class CalculatorCodeIllegalStateErrorTest {
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    private void testSyntaxErrorPosition(String code, int errorPosition){
        try{
            calculator.calculate(code);
            fail("CalculationError Exception should be thrown.");
        } catch (CalculationError error){
            assertEquals("Syntax Error on position: " + Integer.toString(errorPosition),
                    error.getMessage());
            assertEquals(errorPosition, error.getErrorPosition());
        }
    }

    @Test
    public void testCodeLineIllegalState() throws CalculationError {
        testSyntaxErrorPosition("+;",0);
    }

    @Test
    public void testWriteVariableIllegalState() throws CalculationError {
        testSyntaxErrorPosition("a+1;",1);
    }

    @Test
    public void testExpressionIllegalState() throws CalculationError {
        testSyntaxErrorPosition("a=);",2);
    }

    @Test
    public void testExpressionCommandIllegalState() throws CalculationError {
        testSyntaxErrorPosition("a=1 a;",4);
    }

    @Test
    public void testFunctionCommandIllegalState() throws CalculationError {
        testSyntaxErrorPosition("a=out+;",5);
    }

}
