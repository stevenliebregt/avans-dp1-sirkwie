package com.rickensteven.sirkwie.core.domain;

public abstract class Node
{
    protected boolean value;

    public abstract boolean calculate();

    public abstract void accept(INodeVisitor nodeVisitor);

    public boolean getValue()
    {
        return value;
    }

    public void addToCircuit(Circuit circuit)
    {
        circuit.addNode(this);
    }
}
