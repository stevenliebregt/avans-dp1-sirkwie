package com.rickensteven.sirkwie.core.domain;

public abstract class Node
{
    protected boolean value;
    private final String name;

    public Node(String name) {
        this.name = name;
    }

    public boolean getValue()
    {
        return value;
    }
    public String getName() { return name; }

    public abstract boolean calculate();
    public abstract void accept(INodeVisitor nodeVisitor);
    public void addToCircuit(Circuit circuit)
    {
        circuit.addNode(this);
    }
}
