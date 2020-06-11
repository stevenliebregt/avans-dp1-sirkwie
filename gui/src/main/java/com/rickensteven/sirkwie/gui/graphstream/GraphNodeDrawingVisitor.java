package com.rickensteven.sirkwie.gui.graphstream;

import com.rickensteven.sirkwie.core.domain.*;

public class GraphNodeDrawingVisitor implements INodeVisitor
{
    private GraphNodeData value;

    public GraphNodeData getValue()
    {
        return value;
    }

    @Override
    public void visit(Probe node)
    {
        value = new GraphNodeData(node.getName(), "Probe");
    }

    @Override
    public void visit(Input node)
    {
        value = new GraphNodeData(node.getName(), "Input");
    }

    @Override
    public void visit(AndGate node)
    {
        value = new GraphNodeData(node.getName(), "AND");
    }

    @Override
    public void visit(NAndGate node)
    {
        value = new GraphNodeData(node.getName(), "NAND");
    }

    @Override
    public void visit(NOrGate node)
    {
        value = new GraphNodeData(node.getName(), "NOR");
    }

    @Override
    public void visit(NotGate node)
    {
        value = new GraphNodeData(node.getName(), "NOT");
    }

    @Override
    public void visit(OrGate node)
    {
        value = new GraphNodeData(node.getName(), "OR");
    }

    @Override
    public void visit(XOrGate node)
    {
        value = new GraphNodeData(node.getName(), "XOR");
    }
}
