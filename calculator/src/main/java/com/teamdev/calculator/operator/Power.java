package com.teamdev.calculator.operator;

public class Power extends AbstractBinaryOperator {

    public Power(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
