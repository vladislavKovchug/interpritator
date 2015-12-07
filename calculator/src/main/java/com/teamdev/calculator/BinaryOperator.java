package com.teamdev.calculator;

public interface BinaryOperator extends Comparable<BinaryOperator> {
    double execute(double leftOperand, double rightOperand);
}
