package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of an OR port is '1' if one or both of the inputs are '1'.
 *
 *   Input A | Input B | Output
 *  ---------|---------|--------
 *         0 |       0 |      0
 *         0 |       1 |      1
 *         1 |       0 |      1
 *         1 |       1 |      1
 */
public class OrPort extends Port
{
    public OrPort(List<Node> previous)
    {
        super(previous);
    }

    @Override
    public boolean calculate()
    {
        return previous
                .stream()
                .filter(node -> node.value.getValue())
                .count() >= 1;
    }
}
