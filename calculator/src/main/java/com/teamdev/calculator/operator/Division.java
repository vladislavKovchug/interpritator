package com.teamdev.calculator.operator;

/**
 * @author vladislav.kovchug
 */
public class Division extends AbstractBinaryOperator {

    public Division(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        if(rightOperand == 0){
            throw new ArithmeticException();
        }
        return leftOperand / rightOperand;
    }
}
