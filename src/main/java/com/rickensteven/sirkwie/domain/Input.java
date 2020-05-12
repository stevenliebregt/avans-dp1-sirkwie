package com.rickensteven.sirkwie.domain;

import com.rickensteven.sirkwie.Observable;

import java.util.HashSet;

public class Input extends Node
{
    public Input(boolean initialValue)
    {
        super(new HashSet<>());
        this.value = new Observable<>(initialValue);
    }

    @Override
    public boolean calculate()
    {
        return value.getValue();
    }
}
