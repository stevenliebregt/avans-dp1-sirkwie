package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public class Input extends NodeComposite
{
    public Input(boolean value)
    {
        super(null);
        setValue(value);
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }
}
