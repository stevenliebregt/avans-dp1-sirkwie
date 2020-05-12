package com.rickensteven.sirkwie.domain;

import com.rickensteven.sirkwie.Observable;

import java.util.List;

public abstract class Node
{
    protected Observable<Boolean> value;
    protected List<Node> previous;

    public Node(List<Node> previous) {
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
