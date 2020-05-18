package com.rickensteven.sirkwie.core.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeComposite extends Node
{
    protected List<Node> children = new ArrayList<>();

    public NodeComposite(List<Node> previous) {
        super(previous);
    }

    public void add(Node child)
    {
        this.children.add(child);
    }

    public void remove(Node child)
    {
        this.children.remove(child);
    }

    public List<Node> getChildren()
    {
        return this.children;
    }

    public void calculate()
    {
        this.children.forEach(Node::calculate);
    }
}