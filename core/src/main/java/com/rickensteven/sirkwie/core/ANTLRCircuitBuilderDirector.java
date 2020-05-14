package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRCircuitBuilderDirector implements ICircuitBuilderDirector {

    private final CircuitBuilder builder;
    private final CircuitParser parser;

    public ANTLRCircuitBuilderDirector(CircuitBuilder builder, CircuitParser parser) {
        this.builder = builder;
        this.parser = parser;
    }

    //TODO not sure if builder director can parse txt or if it should already receive parsed info
    public void make(String TxtCircuit) {
        this.builder.reset();
        ParseTree parseTree = parser.parse(TxtCircuit);
        //TODO call building methods of builder
    }

}
