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
public class NotGate extends NodeComposite
{
    public NotGate(List<Node> parents, String name)
    {
        super(parents, name);
        if (parents.size() != 1) {
            throw new IllegalArgumentException("The NOT gate must have exactly 1 input");
        }
    }

    public NotGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        return value = !parents.get(0).calculate();
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
