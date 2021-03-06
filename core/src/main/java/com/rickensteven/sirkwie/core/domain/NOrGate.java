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
public class NOrGate extends NodeComposite
{
    public NOrGate(List<Node> parents, String name)
    {
        super(parents, name);
    }

    public NOrGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        notifyStartCalculation();

        for (Node parent : parents) {
            if (parent.calculate()) {
                notifyStopCalculation(false);
                return value = false;
            }
        }

        notifyStopCalculation(true);

        return value = true;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
