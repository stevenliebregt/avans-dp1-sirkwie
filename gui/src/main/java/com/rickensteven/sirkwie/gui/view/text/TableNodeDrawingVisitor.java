package com.rickensteven.sirkwie.gui.view.text;

import com.rickensteven.sirkwie.core.domain.*;

public class TableNodeDrawingVisitor implements INodeVisitor
{
    private TableNodeData value;

    public TableNodeData getValue()
    {
        return value;
    }

    @Override
    public void visit(Probe node)
    {
        value = new TableNodeData("PROBE", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(Input node)
    {
        value = new TableNodeData("INPUT", node.getName(), node.getValue(), null);
    }

    @Override
    public void visit(AndGate node)
    {
        value = new TableNodeData("AND", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(NAndGate node)
    {
        value = new TableNodeData("AND", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(NOrGate node)
    {
        value = new TableNodeData("NOR", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(NotGate node)
    {
        value = new TableNodeData("NOT", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(OrGate node)
    {
        value = new TableNodeData("OR", node.getName(), node.getValue(), node.getParents());
    }

    @Override
    public void visit(XOrGate node)
    {
        value = new TableNodeData("XOR", node.getName(), node.getValue(), node.getParents());
    }
}
