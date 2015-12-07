package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

public class OpeningBracketParser implements ExpressionParser {

    public static final String OPENING_BRACKET = "(";

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(OPENING_BRACKET)) {
            return null;
        }

        reader.movePosition(OPENING_BRACKET.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) {
                outputContext.enterNewContext();
            }
        };
    }
}
