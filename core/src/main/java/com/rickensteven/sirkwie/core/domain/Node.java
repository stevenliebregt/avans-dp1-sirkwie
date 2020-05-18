package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public abstract class Node
{
    protected List<Node> previous;
    protected boolean value;

    public Node(List<Node> previous) {
        this.previous = previous;
    }

    public abstract void calculate();

    public boolean getValue()
    {
        return value;
    }
}
