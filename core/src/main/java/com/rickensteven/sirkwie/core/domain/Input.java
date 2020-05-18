package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public class Input extends NodeComposite
{
    public Input(List<Node> previous)
    {
        super(previous);
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }

    @Override
    public void calculate()
    {
        calculateNext();
    }
}
