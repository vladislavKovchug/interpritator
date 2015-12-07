package com.teamdev.calculator;

import org.junit.Test;

public class CalcolatorCodeSyntaxErrorsTest {

    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void testCalculatorBaseCodeExecution() throws CalculationError {
        calculator.calculate("result=1+1;out(result);");
    }
}
