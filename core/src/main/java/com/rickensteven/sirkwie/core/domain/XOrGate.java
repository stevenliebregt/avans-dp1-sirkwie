package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The output of an XOR gate is only '1' the number of '1' inputs is odd.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      0
 * 0 |       1 |      1
 * 1 |       0 |      1
 * 1 |       1 |      0
 */
public class XOrGate extends NodeComposite
{
    public XOrGate(List<Node> parents, String name)
    {
        super(parents, name);
    }

    public XOrGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        notifyStartCalculation();

        value = parents
                .stream()
                .filter(Node::calculate)
                .count() % 2 == 1;

        notifyStopCalculation(value);

        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
