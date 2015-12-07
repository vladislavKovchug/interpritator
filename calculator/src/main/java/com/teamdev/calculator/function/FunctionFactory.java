package com.teamdev.calculator.function;


import com.teamdev.calculator.Function;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionFactory {

    private final Map<String, Function> functions =
            new HashMap<String, Function>() {{

                put("sum", new Sum());
                put("out", new Out());

            }};


    public Function getFunction(String presentation) {
        return functions.get(presentation);
    }

    public Set<String> getAllPresentations() {
        return functions.keySet();
    }
}
