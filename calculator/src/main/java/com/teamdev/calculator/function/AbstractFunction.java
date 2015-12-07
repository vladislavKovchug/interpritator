package com.teamdev.calculator.function;


import com.teamdev.calculator.Function;

public abstract class AbstractFunction implements Function {

    private final int minArgumentCount;
    private final int maxArgumentCount;

    public AbstractFunction(int minArgumentCount, int maxArgumentCount) {
        this.minArgumentCount = minArgumentCount;
        this.maxArgumentCount = maxArgumentCount;
    }

    public int getMinArgumentCount() {
        return minArgumentCount;
    }

    public int getMaxArgumentCount() {
        return maxArgumentCount;
    }
}
