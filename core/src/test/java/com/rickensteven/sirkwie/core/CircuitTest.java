package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.NotGate;
import com.rickensteven.sirkwie.core.domain.Probe;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CircuitTest
{
    @Test
    public void constructed()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(false);
        NotGate notGate = new NotGate(Collections.singletonList(input));
        Probe probe = new Probe(Collections.singletonList(notGate));

        circuit.addInput(input);
        circuit.addNode(notGate);
        circuit.addProbe(probe);

        assertEquals(1, circuit.getInputs().size());
        assertEquals(3, circuit.getNodes().size());
        assertEquals(1, circuit.getProbes().size());
    }

    @Test
    public void simulate()
    {
        Circuit circuit = new Circuit();

        Input input = new Input(false);
        NotGate notGate = new NotGate(Collections.singletonList(input));
        Probe probe = new Probe(Collections.singletonList(notGate));

        circuit.addInput(input);
        circuit.addNode(notGate);
        circuit.addProbe(probe);

        circuit.simulate();
        assertTrue(probe.getValue());

        input.setValue(true);
        circuit.simulate();
        assertFalse(probe.getValue());
    }
}
