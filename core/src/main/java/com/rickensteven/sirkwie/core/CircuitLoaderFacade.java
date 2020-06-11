package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.building.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.exception.CircuitInfiniteLoopException;
import com.rickensteven.sirkwie.core.exception.CircuitNotConnectedException;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import com.rickensteven.sirkwie.core.parsing.ICircuitParser;
import com.rickensteven.sirkwie.core.validation.CircuitInfiniteLoopValidator;
import com.rickensteven.sirkwie.core.validation.CircuitNotConnectedValidator;

import java.io.IOException;

public class CircuitLoaderFacade
{
    private final CircuitFileReader circuitFileReader;
    private final CircuitNotConnectedValidator circuitNotConnectedValidator;
    private final CircuitInfiniteLoopValidator circuitInfiniteLoopValidator;
    private final ICircuitParser circuitParser;

    public CircuitLoaderFacade(ICircuitParser circuitParser)
    {
        this.circuitParser = circuitParser;

        circuitFileReader = new CircuitFileReader();
        circuitNotConnectedValidator = new CircuitNotConnectedValidator();
        circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();
    }

    public Circuit loadCircuit(String filePath) throws IOException, CircuitSyntaxException, CircuitInfiniteLoopException, CircuitNotConnectedException
    {
        String cleanedTxtCircuit = circuitFileReader.read(filePath);

        // TODO: Not yet sure this is right

        CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
        CircuitDefinition circuitDefinition = circuitParser.parse(cleanedTxtCircuit);
        CircuitBuilder circuitBuilder = new CircuitBuilder();

        circuitBuilderDirector.setCircuitBuilder(circuitBuilder);
        circuitBuilderDirector.construct(circuitDefinition);

        Circuit circuit = circuitBuilder.getCircuit();

        if (circuitNotConnectedValidator.hasDisconnectedProbes(circuit))
            throw new CircuitNotConnectedException("Not all probes are connected"); // TODO: More specific, which node etc? maybe for extra points
        if (circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit))
            throw new CircuitInfiniteLoopException("There are infinite loops in the circuit");

        return circuit;
    }
}
