package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.*;
import com.rickensteven.sirkwie.core.validation.CircuitNotConnectedValidator;
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
        circuit.addProbe(new Probe("P"));

        CircuitNotConnectedValidator circuitNotConnectedValidator = new CircuitNotConnectedValidator();

        assertTrue(circuitNotConnectedValidator.hasDisconnectedProbes(circuit));
    }

    @Test
    public void notAllProbesAreConnectedMultipleProbes()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(true, "I");
        Node nodeA = new NotGate(Collections.singletonList(input), "NA");
        Node nodeB = new AndGate(Collections.emptyList(), "NB"); // Not connected to any input, so this test should fail
        Probe probeA = new Probe(Collections.singletonList(nodeA), "PA");
        Probe probeB = new Probe(Collections.singletonList(nodeB), "PB");

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

        Input input = new Input(true, "I");
        Node node = new NotGate(Collections.singletonList(input), "N");
        Probe probe = new Probe(Collections.singletonList(node), "P");

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

        Input input1 = new Input(true, "I1");
        Input input2 = new Input(false, "I2");

        Node node1 = new NotGate(Collections.singletonList(input1), "N1");
        Node node2 = new NotGate(Collections.singletonList(node1), "N2");

        Node node3 = new AndGate(Collections.emptyList(), "N3"); // This one is not connected to any inputs
        Node node4 = new AndGate(new ArrayList<>()
        {{ // One of the parents is not connected, the other is, so it should be valid
            add(input2);
            add(node3);
        }}, "N4");

        Probe probe1 = new Probe(Collections.singletonList(node4), "P1");
        Probe probe2 = new Probe(Collections.singletonList(input1), "P2");

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
