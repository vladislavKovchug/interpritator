package com.teamdev.calculator.parser;

import com.teamdev.calculator.EvaluationCommand;
import com.teamdev.calculator.EvaluationContext;
import com.teamdev.calculator.ExpressionParser;
import com.teamdev.calculator.MathExpressionReader;

public class ArgumentDelimiterParser implements ExpressionParser {

    public static final String DELIMITER = ",";

    @Override
    public EvaluationCommand accept(MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(DELIMITER)) {
            return null;
        }

        reader.movePosition(DELIMITER.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) {
                outputContext.getEvaluationStack().popAllOperators();
            }
        };
    }
}
