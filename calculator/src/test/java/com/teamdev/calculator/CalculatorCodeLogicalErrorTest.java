package com.teamdev.calculator;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

public class CalculatorCodeLogicalErrorTest {
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    private void testLogicalException(String code, String message, int errorPosition){
        try{
            calculator.calculate(code);
            fail("CalculationError Exception should be thrown.");
        } catch (CalculationError error){
            assertEquals(message,
                    error.getMessage());
            assertEquals(errorPosition, error.getErrorPosition());
        }
    }

    @Test
    public void testNotClosedBracket() throws CalculationError {
        testLogicalException("a=(8+1;", "Error Not closed brackets", 7);
    }

    @Test
    public void testClosingNotOpenedBracket() throws CalculationError {
        calculator.calculate("a=8)+1;out(a);");
    }

    @Test
    public void testIllegalFunctionParameters() throws CalculationError {
        calculator.calculate("a=(8,2)+1;out((a);");
    }

}
