package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public abstract class Port extends Node
{
    public Port(List<Node> previous)
    {
        super(previous);
    }
}
