package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of a NAND port is '1' when not both inputs are '1'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      1
 * 0 |       1 |      1
 * 1 |       0 |      1
 * 1 |       1 |      0
 */
public class NandPort extends Port
{
    public NandPort(List<Node> parents)
    {
        super(parents);
    }

    @Override
    public boolean calculate()
    {
        value = parents.stream()
                .filter(Node::calculate)
                .count() != parents.size();
        return value;
    }
}
