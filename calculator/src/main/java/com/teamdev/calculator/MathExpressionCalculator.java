package com.teamdev.calculator;

import com.teamdev.fsm.AbstractFiniteStateMachine;
import com.teamdev.calculator.parser.ExpressionParserFactory;

import java.util.Map;

public class MathExpressionCalculator extends AbstractFiniteStateMachine<

        MathExpressionReader,
        EvaluationContext,
        CalculationState,
        EvaluationCommand,
        ExpressionParser,
        CalculationMatrix,
        CalculationError>

        implements Calculator {

    final private ExpressionParserFactory parserFactory = new ExpressionParserFactory();
    final private CalculationMatrix matrix = new CalculationMatrix();

    @Override
    public Map<String, Double> calculate(String expression) throws CalculationError {
        final EvaluationContext evaluationContext = new EvaluationContext();
        run(new MathExpressionReader(expression), evaluationContext);
        return evaluationContext.getVariables();
    }


    @Override
    protected void deadlock(MathExpressionReader context) throws CalculationError {
        throw new CalculationError("Syntax Error on position: " + Integer.toString(context.getPosition()),
                context.getPosition());
    }

    @Override
    protected ExpressionParser getStateAcceptor(CalculationState state) {
        return parserFactory.getParser(state);
    }

    @Override
    protected CalculationMatrix getTransitionMatrix() {
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        final MathExpressionCalculator calculator = new MathExpressionCalculator();
        calculator.calculate("a = (2+1); b = a + 5; out( sum (a,b) );");
    }
}
