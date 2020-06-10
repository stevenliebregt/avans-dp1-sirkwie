package com.rickensteven.sirkwie.core.domain;

public class Probe extends NodeComposite
{
    @Override
    public boolean calculate()
    {
        return value = parents.get(0).calculate();
    }

    @Override
    public void addToCircuit(Circuit circuit)
    {
        circuit.addProbe(this);
        super.addToCircuit(circuit);
    }
}
