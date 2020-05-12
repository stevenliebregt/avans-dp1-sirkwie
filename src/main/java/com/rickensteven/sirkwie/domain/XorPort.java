package com.rickensteven.sirkwie.domain;

import java.util.Set;

/**
 * The output of an XOR port is only '1' the number of '1' inputs is odd.
 *
 *   Input A | Input B | Output
 *  ---------|---------|--------
 *         0 |       0 |      0
 *         0 |       1 |      1
 *         1 |       0 |      1
 *         1 |       1 |      0
 */
public class XorPort extends Node
{
    public XorPort(Set<Node> previous)
    {
        super(previous);
    }

    @Override
    public boolean calculate()
    {
        long on = previous.stream()
                .filter(node -> node.value.getValue())
                .count();

        return on % 2 == 0;
    }
}
