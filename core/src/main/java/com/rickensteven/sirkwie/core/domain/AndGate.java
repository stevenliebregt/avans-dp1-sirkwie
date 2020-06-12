package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The output of an AND gate is only '1' when both inputs are also '1'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      0
 * 0 |       1 |      0
 * 1 |       0 |      0
 * 1 |       1 |      1
 */
public class AndGate extends NodeComposite
{
    public AndGate(List<Node> parents, String name)
    {
        super(parents, name);
    }

    public AndGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        for (Node parent : parents) {
            if (!parent.calculate()) return value = false;
        }

        return value = true;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
