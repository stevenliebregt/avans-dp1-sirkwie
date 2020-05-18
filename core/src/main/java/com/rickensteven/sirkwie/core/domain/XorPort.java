package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The output of an XOR port is only '1' the number of '1' inputs is odd.
 * <p>
 * Input A | Input B | Output
 * ---------|---------|--------
 * 0 |       0 |      0
 * 0 |       1 |      1
 * 1 |       0 |      1
 * 1 |       1 |      0
 */
public class XorPort extends Port
{
    public XorPort(List<Node> previous)
    {
        super(previous);
    }

    @Override
    public void calculate()
    {
        long on = previous.stream()
                .filter(Node::getValue)
                .count();

        this.value = on % 2 == 1;
        super.calculate();
    }
}
