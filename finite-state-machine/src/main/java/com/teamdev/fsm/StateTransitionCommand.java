package com.teamdev.fsm;

public interface StateTransitionCommand<
        Context extends OutputContext,
        Error extends Exception> {

    void execute(Context outputContext) throws Error;

}
