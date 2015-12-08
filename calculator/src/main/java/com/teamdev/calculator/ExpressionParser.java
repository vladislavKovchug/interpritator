package com.teamdev.calculator;

import com.teamdev.fsm.StateAcceptor;

public interface ExpressionParser extends StateAcceptor<
        CalculationError,
        MathExpressionReader,
        EvaluationContext,
        EvaluationCommand> {

    @Override
    EvaluationCommand accept(MathExpressionReader reader);
}
