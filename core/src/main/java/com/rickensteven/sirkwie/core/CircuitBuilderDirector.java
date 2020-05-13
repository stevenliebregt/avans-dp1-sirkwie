package com.rickensteven.sirkwie.core;

public class CircuitBuilderDirector {

    private CircuitBuilder builder;

    public CircuitBuilderDirector(CircuitBuilder builder) {
        this.builder = builder;
    }

    //TODO not sure if builder director can parse txt or if it should already receive parsed info
    public void make(String TxtCircuit) {
        this.builder.reset();
        //TODO call building methods of builder
    }

}
