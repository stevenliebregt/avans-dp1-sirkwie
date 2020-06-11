package com.rickensteven.sirkwie.core.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeComposite extends Node
{
    protected final List<Node> parents = new ArrayList<>();

    public NodeComposite(List<Node> parents)
    {
        this.parents.addAll(parents);
    }

    public void add(Node parent)
    {
        this.parents.add(parent);
    }

    public void remove(Node parent)
    {
        this.parents.remove(parent);
    }

    public List<Node> getParents()
    {
        return this.parents;
    }

    public abstract boolean calculate();
}
