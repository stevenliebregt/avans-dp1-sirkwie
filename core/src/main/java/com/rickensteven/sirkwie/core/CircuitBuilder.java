package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;

public class CircuitBuilder
{
    private Circuit circuit;

    public CircuitBuilder()
    {
        this.reset();
    }

    public void addAndPort()
    {

    }

    public void addNandPort()
    {

    }

    public void addNorPort()
    {

    }

    public void addNotPort()
    {

    }

    public void addOrPort()
    {

    }

    public void addXorPort()
    {

    }

    public void addInput()
    {

    }

    public void addProbe()
    {

    }

    public Circuit getCircuit()
    {
        return circuit;
    }

    public void reset()
    {
        this.circuit = new Circuit();
    }
}
