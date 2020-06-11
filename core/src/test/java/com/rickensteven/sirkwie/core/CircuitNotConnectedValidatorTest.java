package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.CircuitNotConnectedValidator;
import com.rickensteven.sirkwie.core.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircuitNotConnectedValidatorTest
{
    @Test
    public void notAllProbesAreConnected()
    {
        Circuit circuit = new Circuit();
        circuit.addProbe(new Probe());

        CircuitNotConnectedValidator circuitNotConnectedValidator = new CircuitNotConnectedValidator();

        assertTrue(circuitNotConnectedValidator.hasDisconnectedProbes(circuit));
    }

    @Test
    public void notAllProbesAreConnectedMultipleProbes()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true);
        Node nodeA = new NotGate(Collections.singletonList(input));
        Node nodeB = new AndGate(Collections.emptyList()); // Not connected to any input, so this test should fail
        Probe probeA = new Probe(Collections.singletonList(nodeA));
        Probe probeB = new Probe(Collections.singletonList(nodeB));

        circuit.addInput(input);
        circuit.addNode(nodeA);
        circuit.addProbe(probeA);
        circuit.addProbe(probeB);

        CircuitNotConnectedValidator circuitNotConnectedValidator = new CircuitNotConnectedValidator();

        assertTrue(circuitNotConnectedValidator.hasDisconnectedProbes(circuit));
    }

    @Test
    public void allProbesAreConnected()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true);
        Node node = new NotGate(Collections.singletonList(input));
        Probe probe = new Probe(Collections.singletonList(node));

        circuit.addInput(input);
        circuit.addNode(node);
        circuit.addProbe(probe);

        CircuitNotConnectedValidator circuitNotConnectedValidator = new CircuitNotConnectedValidator();

        assertFalse(circuitNotConnectedValidator.hasDisconnectedProbes(circuit));
    }

    @Test
    public void allProbesAreConnectedComplex()
    {
        Circuit circuit = new Circuit();

        Input input1 = new Input(true);
        Input input2 = new Input(false);

        Node node1 = new NotGate(Collections.singletonList(input1));
        Node node2 = new NotGate(Collections.singletonList(node1));

        Node node3 = new AndGate(Collections.emptyList()); // This one is not connected to any inputs
        Node node4 = new AndGate(new ArrayList<>() {{ // One of the parents is not connected, the other is, so it should be valid
            add(input2);
            add(node3);
        }});

        Probe probe1 = new Probe(Collections.singletonList(node4));
        Probe probe2 = new Probe(Collections.singletonList(input1));

        circuit.addInput(input1);
        circuit.addInput(input2);
        circuit.addNode(node1);
        circuit.addNode(node2);
        circuit.addNode(node3);
        circuit.addNode(node4);
        circuit.addProbe(probe1);
        circuit.addProbe(probe2);

        CircuitNotConnectedValidator circuitNotConnectedValidator = new CircuitNotConnectedValidator();

        assertFalse(circuitNotConnectedValidator.hasDisconnectedProbes(circuit));
    }
}
