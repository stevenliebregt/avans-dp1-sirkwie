package com.rickensteven.sirkwie.core.domain;

public class Input extends Node
{
    public Input(boolean value)
    {
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
    public void addToCircuit(Circuit circuit)
    {
        circuit.addInput(this);
        super.addToCircuit(circuit);
    }
}
