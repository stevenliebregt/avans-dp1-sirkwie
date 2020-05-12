package com.rickensteven.sirkwie.core.domain;

import com.rickensteven.sirkwie.core.Observable;

import java.util.ArrayList;

public class Input extends Node
{
    public Input(boolean initialValue)
    {
        super(new ArrayList<>());
        this.value = new Observable<>(initialValue);
    }

    @Override
    public boolean calculate()
    {
        return value.getValue();
    }
}
