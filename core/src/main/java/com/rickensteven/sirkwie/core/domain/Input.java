package com.rickensteven.sirkwie.core.domain;

public class Input extends Node
{
    public Input(boolean value, String name)
    {
        super(name);
        setValue(value);
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }

    @Override
    public boolean calculate()
    {
        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }

    @Override
    public void addToCircuit(Circuit circuit)
    {
        circuit.addInput(this);
        super.addToCircuit(circuit);
    }
}
