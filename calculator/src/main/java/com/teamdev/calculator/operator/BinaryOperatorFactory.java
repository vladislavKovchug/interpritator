package com.teamdev.calculator.operator;

import com.teamdev.calculator.BinaryOperator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.calculator.operator.AbstractBinaryOperator.Priority.HIGH;
import static com.teamdev.calculator.operator.AbstractBinaryOperator.Priority.LOW;
import static com.teamdev.calculator.operator.AbstractBinaryOperator.Priority.MEDIUM;

public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> operators =
            new HashMap<String, BinaryOperator>() {{

                put("+", new Plus(LOW));

                put("-", new Minus(LOW));

                put("*", new Multiply(MEDIUM));

                put("/", new Division(MEDIUM));

                put("^", new Power(HIGH));
            }};


    public BinaryOperator getBinaryOperator(String presentation) {
        return operators.get(presentation);
    }

    public Set<String> getAllPresentations() {
        return operators.keySet();
    }
}
