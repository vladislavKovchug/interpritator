package com.teamdev.calculator.parser;

import com.teamdev.calculator.EvaluationCommand;
import com.teamdev.calculator.EvaluationContext;
import com.teamdev.calculator.ExpressionParser;
import com.teamdev.calculator.MathExpressionReader;

public class AssignValueParser implements ExpressionParser {

    public static final String ASSIGN = "=";

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(ASSIGN)) {
            return null;
        }

        reader.movePosition(ASSIGN.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) {
                outputContext.enterNewContext();
            }
        };
    }
}
