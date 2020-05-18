package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public class Probe extends Node
{

    public Probe(List<Node> previous)
    {
        super(previous);
    }

    @Override
    public void calculate()
    {
        this.value = previous.get(0).value;
    }
}
