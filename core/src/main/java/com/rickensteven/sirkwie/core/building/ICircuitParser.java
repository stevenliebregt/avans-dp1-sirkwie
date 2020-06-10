package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;

public interface ICircuitParser
{
    CircuitDefinition parse(String cleanedTxtCircuit) throws CircuitSyntaxException;
}
