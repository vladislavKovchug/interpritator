package com.teamdev.calculator;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MathExpressionCalculationTest {
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    private double getCalculationResult(String code) throws CalculationError {
        final Map<String, Double> variables = calculator.calculate(code);
        return variables.get("result");
    }

    private void assertCalculation(String code, double expected) throws CalculationError {
        assertEquals("wrong calculation of " + code, expected,
                getCalculationResult(code), 0.01);
    }

    @Test
    public void testMathExpressionWithSingleNumberCalculation() throws CalculationError {
        assertCalculation("result=1;", 1.0);
        assertCalculation("result=1.0;", 1.0);
        assertCalculation("result=55;", 55.0);
        assertCalculation("result=55.33;", 55.33);
    }

    @Test
    public void testMathExpressionWithBinaryOperators() throws CalculationError {
        assertCalculation("result=1 + 2;", 3.0);
        assertCalculation("result=1 - 2;", -1.0);
        assertCalculation("result=1 * 2;", 2.0);
        assertCalculation("result=1 / 2;", 0.5);
        assertCalculation("result=1 ^ 2;", 1.0);

        assertCalculation("result=1 + 2 * 3 ^ 4;", 163.0);
    }

    @Test
    public void testMathExpressionBinaryOperatorsWithPriority() throws CalculationError {
        assertCalculation("result=1 + 2 * 3 ^ 4;", 163.0);
    }

    @Test
    public void testMathExpressionWithBrackets() throws CalculationError {
        assertCalculation("result=2*(1 + 2) - 7;", -1.0);
        assertCalculation("result=2*(1*(1 + 2) + (5-6) + 1) - 7;", -1.0);
    }

    @Test
    public void testMathExpressionWithFunctions() throws CalculationError {
        assertCalculation("result=sum(1, 2);", 3);
        assertCalculation("result=sum(1, sum(2, 3+1));", 7);
    }

}
