package com.teamdev.fsm;


public interface StateAcceptor<
        Error extends Exception,
        Input extends InputContext,
        Output extends OutputContext,
        Command extends StateTransitionCommand<Output, Error>> {

    Command accept(Input inputContext);
}
