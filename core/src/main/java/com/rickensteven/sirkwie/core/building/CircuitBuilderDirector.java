package com.rickensteven.sirkwie.core.building;

public class CircuitBuilderDirector
{
    private CircuitBuilder circuitBuilder;

    public void setCircuitBuilder(CircuitBuilder circuitBuilder)
    {
        this.circuitBuilder = circuitBuilder;
    }

    public void construct(CircuitDefinition circuitDefinition)
    {
        circuitBuilder.reset(circuitDefinition);
        circuitBuilder.buildNodes();
        circuitBuilder.buildEdges();
    }
}
