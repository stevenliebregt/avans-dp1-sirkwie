package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of a NOR port is '1' when both inputs are '0'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      1
 * 0 |       1 |      0
 * 1 |       0 |      0
 * 1 |       1 |      0
 */
public class NorPort extends Port
{
    public NorPort(List<Node> previous)
    {
        super(previous);
    }

    @Override
    public boolean calculate()
    {
        return previous
                .stream()
                .noneMatch(node -> node.value.getValue());
    }
}
