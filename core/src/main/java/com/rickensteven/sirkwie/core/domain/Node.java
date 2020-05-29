package com.rickensteven.sirkwie.core.domain;

public abstract class Node
{
    protected boolean value;

    public abstract boolean calculate();

    public boolean getValue()
    {
        return value;
    }
}
