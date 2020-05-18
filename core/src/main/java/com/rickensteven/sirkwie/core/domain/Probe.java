package com.rickensteven.sirkwie.core.domain;

public class Probe extends Node
{

    private final Node previous;

    public Probe(Node previous)
    {
        this.previous = previous;
    }

    @Override
    public void calculate()
    {
        this.value = previous.value;
    }
}
