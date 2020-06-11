package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

public class NodeParentableVisitor implements INodeVisitor
{
    private boolean parentable = false;

    public boolean isParentable()
    {
        return parentable;
    }

    @Override
    public void visit(Probe node)
    {
        parentable = true;
    }

    @Override
    public void visit(Input node)
    {
        parentable = false;
    }

    @Override
    public void visit(AndGate node)
    {
        parentable = true;
    }

    @Override
    public void visit(NAndGate node)
    {
        parentable = true;
    }

    @Override
    public void visit(NOrGate node)
    {
        parentable = true;
    }

    @Override
    public void visit(NotGate node)
    {
        parentable = true;
    }

    @Override
    public void visit(OrGate node)
    {
        parentable = true;
    }

    @Override
    public void visit(XOrGate node)
    {
        parentable = true;
    }
}
