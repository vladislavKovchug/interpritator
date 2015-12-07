package com.teamdev.fsm;


import java.util.Set;

public abstract class AbstractFiniteStateMachine<

        Input extends InputContext,
        Output extends OutputContext,
        State extends MachineState,
        Command extends StateTransitionCommand<Output>,
        Acceptor extends StateAcceptor<Input, Output, Command>,
        Matrix extends TransitionMatrix<State>,
        Error extends Exception> {

    public void run(Input inputContext, Output outputContext) throws Error {

        final Matrix matrix = getTransitionMatrix();

        State state = matrix.getStartState();

        while (state != matrix.getFinishState()) {

            state = moveForward(state, inputContext, outputContext);

            if (state == null) {
                deadlock(inputContext);
                break;
            }
        }
    }

    private State moveForward(State currentState,
                              Input inputContext, Output outputContext) {

        final Set<State> possibleTransitions = getTransitionMatrix().
                getPossibleTransitions(currentState);


        for (State expectedState : possibleTransitions) {

            final Acceptor acceptor = getStateAcceptor(expectedState);

            final Command transitionCommand = acceptor.accept(inputContext);

            if (transitionCommand != null) {
                transitionCommand.execute(outputContext);
                return expectedState;
            }
        }

        return null;
    }

    protected abstract void deadlock(Input context) throws Error;

    protected abstract Acceptor getStateAcceptor(State state);

    protected abstract Matrix getTransitionMatrix();
}
