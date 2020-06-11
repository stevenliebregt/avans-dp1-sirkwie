package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.building.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.building.ICircuitParser;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.exception.CircuitInfiniteLoopException;
import com.rickensteven.sirkwie.core.exception.CircuitNotConnectedException;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;

import java.io.IOException;

public class CircuitLoaderFacade
{
    private CircuitFileReader circuitFileReader;
    private ICircuitParser circuitParser;

    public CircuitLoaderFacade(ICircuitParser circuitParser)
    {
        this.circuitParser = circuitParser;
        circuitFileReader = new CircuitFileReader();
    }

    public Circuit loadCircuit(String filePath)
            throws IOException, CircuitSyntaxException, CircuitInfiniteLoopException, CircuitNotConnectedException
    {
        String cleanedTxtCircuit = circuitFileReader.read(filePath);

        // TODO: Not yet sure this is right

        CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
        CircuitDefinition circuitDefinition = circuitParser.parse(cleanedTxtCircuit);
        CircuitBuilder circuitBuilder = new CircuitBuilder();

        circuitBuilderDirector.setCircuitBuilder(circuitBuilder);
        circuitBuilderDirector.construct(circuitDefinition);

        return circuitBuilder.getCircuit();
    }
}
