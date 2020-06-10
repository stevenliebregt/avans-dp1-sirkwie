package com.rickensteven.sirkwie.core.exception;

public class CircuitNotConnectedException extends RuntimeException
{
    public CircuitNotConnectedException(String errorMessage)
    {
        super(errorMessage);
    }
}
