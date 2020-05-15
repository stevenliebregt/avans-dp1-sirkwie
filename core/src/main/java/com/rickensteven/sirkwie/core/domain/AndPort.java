package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of an AND port is only '1' when both inputs are also '1'.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      0
 * 0 |       1 |      0
 * 1 |       0 |      0
 * 1 |       1 |      1
 */
public class AndPort extends Port
{
    public AndPort(List<Node> previous) {
        super(previous);
    }

    @Override
    public void calculate()
    {
        value = previous.stream()
                .filter(node -> node.value)
                .count() == previous.size();
        calculateNext();
    }
}
