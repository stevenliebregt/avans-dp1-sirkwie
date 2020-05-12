package com.rickensteven.sirkwie.domain;

import com.rickensteven.sirkwie.Observable;

import java.util.Set;

public abstract class Node
{
    protected Observable<Boolean> value;
    protected Set<Node> previous;

    public Node(Set<Node> previous) {
        // TODO: Set previous
        // TODO: Set next
        this.previous = previous;

        this.value = new Observable<>(false); // TODO: Check this

        previous.forEach(node -> node.value.subscribe((newValue) -> {
            this.value.setValue(this.calculate());
            return null;
        }));
    }

    public abstract boolean calculate();

    public Observable<Boolean> getValue()
    {
        return value;
    }
}
