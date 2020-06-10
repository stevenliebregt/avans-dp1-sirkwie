package com.rickensteven.sirkwie.core.domain;

public class Probe extends NodeComposite
{
    @Override
    public boolean calculate()
    {
        value = parents.get(0).calculate();
        return value;
    }
}
