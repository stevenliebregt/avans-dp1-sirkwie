package com.rickensteven.sirkwie.core.domain;

import java.util.List;

/**
 * The NOT port inverts the input.
 * <p>
 * Input A | Output
 * ---------|--------
 * 0 |      1
 * 1 |      0
 */
public class NotPort extends Port
{
    public NotPort(List<Node> previous)
    {
        super(previous);

        if (previous.size() != 1) {
            throw new IllegalArgumentException("The NOT port must have exactly 1 input");
        }
    }

    @Override
    public void calculate()
    {
        value = !previous.get(0).value;
        calculateNext();
    }
}
