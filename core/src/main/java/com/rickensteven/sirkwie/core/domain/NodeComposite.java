package com.rickensteven.sirkwie.core.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeComposite extends Node
{
    // Called parents because they are in the context of the circuit
    protected List<Node> parents = new ArrayList<>();

    public NodeComposite(List<Node> parents) {
        this.parents.addAll(parents);
    }

    public NodeComposite() {}

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
