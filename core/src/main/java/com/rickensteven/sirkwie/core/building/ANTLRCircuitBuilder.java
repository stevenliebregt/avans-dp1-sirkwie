package com.rickensteven.sirkwie.core.building;

import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRCircuitBuilder extends CircuitBuilder
{
    private ANTLRCircuitParser antlrCircuitParser;
    private ParseTree parseTree;

    public ANTLRCircuitBuilder(ANTLRCircuitParser antlrCircuitParser)
    {
        this.antlrCircuitParser = antlrCircuitParser;
    }

    @Override
    public void reset(String cleanedTxtCircuit)
    {
        super.reset(cleanedTxtCircuit);
        this.parseTree = antlrCircuitParser.parse(cleanedTxtCircuit);
    }

    @Override
    public void buildNodes()
    {
        System.out.println("I should build nodes");
        System.out.println(parseTree.toStringTree());
        // TODO:
    }

    @Override
    public void buildEdges()
    {
        System.out.println("I should build edges");
        System.out.println(parseTree.toStringTree());
        // TODO:
    }
}
