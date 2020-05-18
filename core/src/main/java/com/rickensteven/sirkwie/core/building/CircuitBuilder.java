package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Circuit;

public abstract class CircuitBuilder
{
    protected Circuit circuit;

    public Circuit getCircuit()
    {
        return circuit;
    }

    public void reset(String cleanedTxtCircuit)
    {
        this.circuit = new Circuit();
    }

    // TODO: Maybe not 100% correct yet, but it's about the idea
    public abstract void buildNodes();
    public abstract void buildEdges();
}
