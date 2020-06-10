package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Circuit;

public class CircuitBuilder
{
    // TODO: Template
    private CircuitDefinition circuitDefinition;
    private Circuit circuit;

    public Circuit getCircuit()
    {
        return circuit;
    }

    // TODO: Maybe not 100% correct yet, but it's about the idea

    public void reset(CircuitDefinition circuitDefinition)
    {
        this.circuitDefinition = circuitDefinition;
        circuit = new Circuit();
    }

    public void buildNodes()
    {
        System.out.println("I should build nodes");
        System.out.println(circuitDefinition.getNodes());
        // TODO:
    }

    public void buildEdges()
    {
        System.out.println("I should build edges");
        System.out.println(circuitDefinition.getEdges());
        // TODO:
    }
}
