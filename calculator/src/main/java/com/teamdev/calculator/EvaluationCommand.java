package com.teamdev.calculator;

import com.teamdev.fsm.StateTransitionCommand;

public interface EvaluationCommand extends StateTransitionCommand<EvaluationContext, CalculationError> {

    @Override
    void execute(EvaluationContext outputContext) throws CalculationError;
}
