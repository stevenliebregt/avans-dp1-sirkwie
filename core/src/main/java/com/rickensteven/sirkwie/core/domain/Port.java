package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public abstract class Port extends NodeComposite
{
    protected List<Node> previous;
    public Port(List<Node> previous)
    {
        this.previous = previous;
    }
}
