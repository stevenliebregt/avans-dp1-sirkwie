package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

/**
 * The output of a NAND gate is '1' when not both inputs are '1'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      1
 * 0 |       1 |      1
 * 1 |       0 |      1
 * 1 |       1 |      0
 */
public class NAndGate extends Gate
{
    public NAndGate(List<Node> parents, String name)
    {
        super(parents, name);
    }
    public NAndGate(String name)
    {
        super(Collections.emptyList(), name);
    }

    @Override
    public boolean calculate()
    {
        value = parents.stream()
                .filter(Node::calculate)
                .count() != parents.size();
        return value;
    }

    @Override
    public void accept(INodeVisitor nodeVisitor)
    {
        nodeVisitor.visit(this);
    }
}
