package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public abstract class Port extends NodeComposite
{
    public Port(List<Node> parents)
    {
        super(parents);
    }
}
