package com.rickensteven.sirkwie.gui;

import com.rickensteven.sirkwie.core.domain.*;

public class NodeDrawingVisitor implements INodeVisitor
{
    private String value;

    public String getValue()
    {
        return value;
    }

    @Override
    public void visit(Probe node)
    {
        value = node.getValue() ? "Probe - AAN" : "Probe - UIT";
    }

    @Override
    public void visit(Input node)
    {
        value = node.getValue() ? "Input - AAN" : "Input - UIT";
    }

    @Override
    public void visit(AndGate node)
    {
        value = "AndGate";
    }

    @Override
    public void visit(NAndGate node)
    {
        value = "NAndGate";
    }

    @Override
    public void visit(NOrGate node)
    {
        value = "NOrGate";
    }

    @Override
    public void visit(NotGate node)
    {
        value = "NotGate";
    }

    @Override
    public void visit(OrGate node)
    {
        value = "OrGate";
    }

    @Override
    public void visit(XOrGate node)
    {
        value = "XOrGate";
    }
}
