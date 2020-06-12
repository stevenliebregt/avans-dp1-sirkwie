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
import java.util.HashSet;
import java.util.Set;

public class CircuitLoaderFacade
{
    private final CircuitFileReader circuitFileReader;
    private final CircuitNotConnectedValidator circuitNotConnectedValidator;
    private final CircuitInfiniteLoopValidator circuitInfiniteLoopValidator;
    private final ICircuitParser circuitParser;
    private final Set<ISimulationListener> simulationListeners;

    public CircuitLoaderFacade(ICircuitParser circuitParser)
    {
        this.circuitParser = circuitParser;

        circuitFileReader = new CircuitFileReader();
        circuitNotConnectedValidator = new CircuitNotConnectedValidator();
        circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();
        simulationListeners = new HashSet<>();
    }

    /**
     * Loads a circuit, which has been simulated before returning it so all
     * values are initially correct.
     *
     * @param filePath The path of the circuit file to load.
     * @return A circuit which has been simulated.
     * @throws IOException When the circuit file could not be read.
     * @throws CircuitSyntaxException When the circuit file contains syntax errors.
     * @throws CircuitInfiniteLoopException When the circuit contains an infinite loop.
     * @throws CircuitNotConnectedException When the circuit has probes that are not connected.
     */
    public Circuit loadCircuit(String filePath) throws IOException, CircuitSyntaxException, CircuitInfiniteLoopException, CircuitNotConnectedException
    {
        String cleanedTxtCircuit = circuitFileReader.read(filePath);

        CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
        CircuitDefinition circuitDefinition = circuitParser.parse(cleanedTxtCircuit);
        CircuitBuilder circuitBuilder = new CircuitBuilder();

        circuitBuilderDirector.setCircuitBuilder(circuitBuilder);
        circuitBuilderDirector.construct(circuitDefinition);

        Circuit circuit = circuitBuilder.getCircuit();
        circuit.addSimulationListeners(simulationListeners);

        // It is important that we first check for infinite loops, otherwise we
        // will get a StackOverflow exception when checking for disconnected probes
        if (circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit))
            throw new CircuitInfiniteLoopException("There are infinite loops in the circuit");
        if (circuitNotConnectedValidator.hasDisconnectedProbes(circuit))
            throw new CircuitNotConnectedException("Not all probes are connected"); // TODO: More specific, which node etc?

        circuit.simulate();

        return circuit;
    }

    public void addSimulationListener(ISimulationListener simulationListener)
    {
        simulationListeners.add(simulationListener);
    }
}
