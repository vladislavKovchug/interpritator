package com.teamdev.calculator.parser;

import com.teamdev.calculator.*;

public class EndOfLineParser implements ExpressionParser {

    public static final String DELIMITER = ";";

    @Override
    public EvaluationCommand accept(final MathExpressionReader reader) {

        if (!reader.hasMoreElements()) {
            return null;
        }

        if (!reader.getRemainingExpression().startsWith(DELIMITER)) {
            return null;
        }

        reader.movePosition(DELIMITER.length());

        return new EvaluationCommand() {
            @Override
            public void execute(EvaluationContext outputContext) throws CalculationError {

                if (outputContext.getEvaluationStack().getParent() != null) {
                    outputContext.closeCurrentContext();
                }

                if(outputContext.getEvaluationStack().getParent() != null){
                    throw new CalculationError("Error Not closed brackets", reader.getPosition());
                }

            }
        };
    }
}
