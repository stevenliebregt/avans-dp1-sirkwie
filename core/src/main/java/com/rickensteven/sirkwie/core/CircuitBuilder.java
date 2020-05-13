package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;

public class CircuitBuilder
{
    private Circuit circuit;

    public CircuitBuilder() {
        this.reset();
    }

    //TODO add methods for building circuit
    public void addPort() {

    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void reset() {
        this.circuit = new Circuit();
    }
}
