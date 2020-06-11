package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.*;
import com.rickensteven.sirkwie.core.parsing.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.validation.CircuitInfiniteLoopValidator;
import com.rickensteven.sirkwie.core.util.ReadTestCircuitFileUtil;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircuitInfiniteLoopValidatorTest
{
    @Test
    public void hasInfiniteLoops()
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
    public void hasNoInfiniteLoopsSimplest()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true);
        Probe probe = new Probe(Collections.singletonList(input));

        circuit.addInput(input);
        circuit.addProbe(probe);

        CircuitInfiniteLoopValidator circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();

        assertFalse(circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit));
    }

    @Test
    public void hasNoInfiniteLoopsSimple1()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true);
        Node node = new NotGate(Collections.singletonList(input));
        Probe probe = new Probe(Collections.singletonList(node));

        circuit.addInput(input);
        circuit.addNode(node);
        circuit.addProbe(probe);

        CircuitInfiniteLoopValidator circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();

        assertFalse(circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit));
    }

    @Test
    public void hasNoInfiniteLoopsSimple2()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true);
        Node node1 = new NotGate(Collections.singletonList(input));
        Node node2 = new NotGate(Collections.singletonList(node1));
        Probe probe = new Probe(Collections.singletonList(node2));

        circuit.addInput(input);
        circuit.addNode(node1);
        circuit.addNode(node2);
        circuit.addProbe(probe);

        CircuitInfiniteLoopValidator circuitInfiniteLoopValidator = new CircuitInfiniteLoopValidator();

        assertFalse(circuitInfiniteLoopValidator.circuitHasInfiniteLoops(circuit));
    }

    @Test
    public void hasNoInfiniteLoops()
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
