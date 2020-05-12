package com.rickensteven.sirkwie.domain;

/**
 * The output of an AND port is only '1' when both inputs are also '1'.
 *
 *   Input A | Input B | Output
 *  ---------|---------|--------
 *         0 |       0 |      0
 *         0 |       1 |      0
 *         1 |       0 |      0
 *         1 |       1 |      1
 */
public class AndPort extends Node
{
    @Override
    public void calculate()
    {
        value.setValue(
                previous.stream()
                        .filter(node -> node.value.getValue())
                        .count() == previous.size()
        );
    }
}
