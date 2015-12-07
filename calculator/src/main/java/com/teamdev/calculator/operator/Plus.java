package com.teamdev.calculator.operator;

public class Plus extends AbstractBinaryOperator {

    public Plus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
