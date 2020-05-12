package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of a NAND port is '1' when not both inputs are '1'.
 *
 *   Input A | Input B | Output
 *  ---------|---------|--------
 *         0 |       0 |      1
 *         0 |       1 |      1
 *         1 |       0 |      1
 *         1 |       1 |      0
 */
public class NandPort extends Port
{
    public NandPort(List<Node> previous)
    {
        super(previous);
    }

    @Override
    public boolean calculate()
    {
        return previous.stream()
                .filter(node -> node.value.getValue())
                .count() != previous.size();
    }
}
