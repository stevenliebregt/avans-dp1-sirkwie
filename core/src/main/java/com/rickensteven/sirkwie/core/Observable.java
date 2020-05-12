package com.rickensteven.sirkwie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Observable<T>
{
    private T value;
    private List<Function<T, Void>> subscribers = new ArrayList<>();

    public Observable(T value)
    {
        this.value = value;
    }

    public void subscribe(Function<T, Void> subscriber)
    {
        subscribers.add(subscriber);
    }

    public void setValue(T newValue)
    {
        value = newValue;
        subscribers.forEach(subscriber -> subscriber.apply(value));
    }

    public T getValue()
    {
        return value;
    }
}
