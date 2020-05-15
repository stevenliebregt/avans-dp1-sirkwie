package com.rickensteven.sirkwie.core.domain;

public abstract class Node
{
    protected boolean value;
    public abstract void calculate();
    public boolean getValue() {
        return value;
    }
}
