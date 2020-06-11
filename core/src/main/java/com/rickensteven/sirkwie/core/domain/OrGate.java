package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The output of an OR gate is '1' if one or both of the inputs are '1'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      0
 * 0 |       1 |      1
 * 1 |       0 |      1
 * 1 |       1 |      1
 */
public class OrGate extends Gate
{
    public OrGate(List<Node> parents, String name)
    {
        super(parents, name);
    }
    public OrGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        value = parents
                .stream()
                .filter(Node::calculate)
                .count() >= 1;
        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
