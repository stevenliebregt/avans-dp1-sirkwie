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
public class OrGate extends NodeComposite
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
        notifyStartCalculation();

        for (Node parent : parents) {
            if (parent.calculate()) {
                notifyStopCalculation(true);
                return value = true;
            }
        }

        notifyStopCalculation(false);

        return value = false;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
