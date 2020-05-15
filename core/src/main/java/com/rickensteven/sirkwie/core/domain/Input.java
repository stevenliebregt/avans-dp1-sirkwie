package com.rickensteven.sirkwie.core.domain;

public class Input extends NodeComposite
{
    public Input(boolean value) {
        setValue(value);
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public void calculate()
    {
        calculateNext();
    }
}
