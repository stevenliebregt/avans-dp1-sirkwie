package com.rickensteven.sirkwie.core.exception;

public class CircuitInfiniteLoopException extends RuntimeException
{
    public CircuitInfiniteLoopException(String errorMessage)
    {
        super(errorMessage);
    }
}
