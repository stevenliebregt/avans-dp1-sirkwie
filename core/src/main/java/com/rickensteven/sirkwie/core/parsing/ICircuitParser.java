package com.rickensteven.sirkwie.core.parsing;

import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;

public interface ICircuitParser
{
    CircuitDefinition parse(String cleanedTxtCircuit) throws CircuitSyntaxException;
}
