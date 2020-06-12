package com.rickensteven.sirkwie.core.domain;

import com.rickensteven.sirkwie.core.ISimulationListener;

import java.util.HashSet;
import java.util.Set;

public abstract class Node
{
    protected boolean value;
    private final String name;
    private final Set<ISimulationListener> simulationListeners;

    public Node(String name)
    {
        this.name = name;
        simulationListeners = new HashSet<>();
    }

    public boolean getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }

    public void addSimulationListener(ISimulationListener simulationListener)
    {
        simulationListeners.add(simulationListener);
    }

    protected void notifyStartCalculation()
    {
        simulationListeners.forEach(listener -> listener.onStartCalculate(this));
    }

    protected void notifyStopCalculation(boolean calculatedValue)
    {
        simulationListeners.forEach(listener -> listener.onStopCalculate(this, calculatedValue));
    }

    public abstract boolean calculate();

    public abstract void accept(INodeVisitor nodeVisitor);

    public void addToCircuit(Circuit circuit)
    {
        circuit.addNode(this);
    }
}
