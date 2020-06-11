package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.building.CircuitInfiniteLoopValidator;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.util.ReadTestCircuitFileUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircuitInfiniteLoopValidatorTest
{
    @Test
    @Disabled
    public void hasInfiniteLoops() // TODO:
    {
        String circuitTxtClean = ReadTestCircuitFileUtil.read("CircuitValidatorInfiniteLoop.txt");

        ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
        CircuitBuilder circuitBuilder = new CircuitBuilder();
        circuitBuilder.reset(antlrCircuitParser.parse(circuitTxtClean));
        circuitBuilder.buildNodes();
        circuitBuilder.buildEdges();

        Circuit circuit = circuitBuilder.getCircuit();

        CircuitInfiniteLoopValidator circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();

        assertTrue(circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit));
    }

    @Test
    @Disabled
    public void hasNoInfiniteLoops() // TODO:
    {
        String circuitTxtClean = ReadTestCircuitFileUtil.read("CircuitValidatorNoInfiniteLoop.txt");

        ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
        CircuitBuilder circuitBuilder = new CircuitBuilder();
        circuitBuilder.reset(antlrCircuitParser.parse(circuitTxtClean));
        circuitBuilder.buildNodes();
        circuitBuilder.buildEdges();

        Circuit circuit = circuitBuilder.getCircuit();

        CircuitInfiniteLoopValidator circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();

        assertFalse(circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit));
    }
}
