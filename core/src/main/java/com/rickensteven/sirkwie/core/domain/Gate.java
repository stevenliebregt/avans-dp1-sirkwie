package com.rickensteven.sirkwie.core.domain;

import java.util.List;

public abstract class Gate extends NodeComposite
{
    public Gate(List<Node> parents)
    {
        super(parents);
    }
}
