package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public class Probe extends NodeComposite
{
    public Probe(List<Node> parents)
    {
        super(parents);

        if (parents.size() != 1) {
            throw new IllegalArgumentException("The probe must have exactly 1 input");
        }
    }

    @Override
    public boolean calculate()
    {
        return value = parents.get(0).calculate();
    }
}
