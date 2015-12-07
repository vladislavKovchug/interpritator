package com.teamdev.calculator;

import java.util.Map;

public interface Calculator {

    Map<String, Double> calculate(String expression) throws CalculationError;

}
