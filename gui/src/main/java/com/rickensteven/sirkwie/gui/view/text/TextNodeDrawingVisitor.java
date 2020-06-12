package com.rickensteven.sirkwie.gui.view.text;

import com.rickensteven.sirkwie.core.domain.*;

public class TextNodeDrawingVisitor implements INodeVisitor
{
    private String value;

    public String getValue()
    {
        return value;
    }

    @Override
    public void visit(Probe node)
    {
        value = "PROBE " + " = " + node.getValue();
    }

    @Override
    public void visit(Input node)
    {
        value = "INPUT";
    }

    @Override
    public void visit(AndGate node)
    {
        value = "AND";
    }

    @Override
    public void visit(NAndGate node)
    {
        value = "NAND";
    }

    @Override
    public void visit(NOrGate node)
    {
        value = "NOR";
    }

    @Override
    public void visit(NotGate node)
    {
        value = "NOT";
    }

    @Override
    public void visit(OrGate node)
    {
        value = "OR";
    }

    @Override
    public void visit(XOrGate node)
    {
        value = "XOR";
    }
}
