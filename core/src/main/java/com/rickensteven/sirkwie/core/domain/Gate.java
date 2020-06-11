package com.rickensteven.sirkwie.core.domain;

import java.util.Collections;
import java.util.List;

public abstract class Gate extends NodeComposite
{
    //TODO remove Gate as it may be redundant
    public Gate(List<Node> parents)
    {
        super(parents);
    }
}
