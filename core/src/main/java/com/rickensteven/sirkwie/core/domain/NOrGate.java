package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The output of a NOR gate is '1' when both inputs are '0'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      1
 * 0 |       1 |      0
 * 1 |       0 |      0
 * 1 |       1 |      0
 */
public class NOrGate extends Gate
{
    public NOrGate(List<Node> parents)
    {
        super(parents);
    }
    public NOrGate()
    {
        super(Collections.emptyList());
    }

    @Override
    public boolean calculate()
    {
        value = parents
                .stream()
                .noneMatch(Node::calculate);
        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
