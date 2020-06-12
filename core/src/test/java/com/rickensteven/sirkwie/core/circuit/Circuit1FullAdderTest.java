package com.rickensteven.sirkwie.core.circuit;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.util.ReadTestCircuitFileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Circuit1FullAdderTest
{
    private Circuit circuit;

    @BeforeEach
    public void beforeEach()
    {
        circuit = ReadTestCircuitFileUtil.getCircuit("Circuit1_FullAdder.txt");
    }

    @Test
    public void checkBuild()
    {
        assertTrue(circuit.getInput("A").getValue());
        assertTrue(circuit.getInput("B").getValue());
        assertFalse(circuit.getInput("Cin").getValue());

        assertEquals(3, circuit.getInputs().size());
        assertEquals(16, circuit.getNodes().size());
        assertEquals(2, circuit.getProbes().size());
    }

    @Test
    public void simulate()
    {
        circuit.simulate();

        assertFalse(circuit.getProbe("S").getValue());
        assertTrue(circuit.getProbe("Cout").getValue());

        // When setting Cin to ON, all probes should be on
        circuit.getInput("Cin").setValue(true);
        circuit.simulate();

        assertTrue(circuit.getProbe("S").getValue());
        assertTrue(circuit.getProbe("Cout").getValue());

        // When toggling all inputs to OGG, all probes should be off
        circuit.getInputs().forEach(input -> input.setValue(false));
        circuit.simulate();

        circuit.getProbes().forEach(probe -> assertFalse(probe.getValue()));
    }
}
