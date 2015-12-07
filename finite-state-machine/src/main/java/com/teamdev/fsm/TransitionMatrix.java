package com.teamdev.fsm;


import java.util.Set;

public interface TransitionMatrix<State extends MachineState> {

    State getStartState();

    State getFinishState();

    Set<State> getPossibleTransitions(State state);

}
