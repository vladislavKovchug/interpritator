package com.teamdev.calculator.operator;

/**
 * @author vladislav.kovchug
 */
public class Minus extends AbstractBinaryOperator {
    public Minus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
