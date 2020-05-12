package com.rickensteven.sirkwie.domain;

import com.rickensteven.sirkwie.Observable;

import java.util.HashSet;
import java.util.Set;

public abstract class Node
{
    protected Observable<Boolean> value;
    protected Set<Node> previous = new HashSet<>();
    protected Set<Node> next = new HashSet<>();

    public Node() {
        // TODO: Set previous
        // TODO: Set next

        previous.forEach(node -> node.value.subscribe((newValue) -> {
            this.calculate();
            return null;
        }));
    }

    public abstract void calculate();

    public Observable<Boolean> getValue()
    {
        return value;
    }
}
