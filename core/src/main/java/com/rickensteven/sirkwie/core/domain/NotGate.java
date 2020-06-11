package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The NOT gate inverts the input.
 * <p>
 * Input A | Output
 * ---------|--------
 * 0 |      1
 * 1 |      0
 */
public class NotGate extends Gate
{
    public NotGate(List<Node> parents)
    {
        super(parents);
        if (parents.size() != 1) {
            throw new IllegalArgumentException("The NOT gate must have exactly 1 input");
        }
    }
    public NotGate()
    {
        super(Collections.emptyList());
    }

    @Override
    public boolean calculate()
    {
        value = !parents.get(0).calculate();
        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
