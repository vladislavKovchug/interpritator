package com.teamdev.calculator;

import org.junit.Test;

public class CalculatorCodeSyntaxTest {
    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    @Test
    public void testCalculatorBaseCodeExecution() throws CalculationError {
        calculator.calculate("result=1+1;out(result);");
    }

    @Test
    public void testCalculatorVariables() throws CalculationError {
        calculator.calculate("a=1;b=a+1;b=b+7;result=b+7^a;out(result);");
    }

    @Test
    public void testCalculatorBrackets() throws CalculationError {
        calculator.calculate("result=(1);out(result);");
        calculator.calculate("result=(1+1);out(result);");
        calculator.calculate("result=(1+(1));out(result);");
        calculator.calculate("result=(1+((1)));out(result);");
    }

    @Test
    public void testCalculatorFunctiobs() throws CalculationError {
        calculator.calculate("result=sum(1,2);out(result);");
        calculator.calculate("result=sum(1,2,3,4,5);out(result);");
        calculator.calculate("result=sum(1,sum(1+(1)));out(result);");
    }

}
