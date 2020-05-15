package com.rickensteven.sirkwie.core.domain;

import java.util.ArrayList;
import java.util.Collections;

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
    public NotPort(Node previous)
    {
        super(new ArrayList<>(Collections.singletonList(previous)));
    }

    @Override
    public void calculate()
    {
        value = !previous.get(0).value;
        calculateNext();
    }
}
