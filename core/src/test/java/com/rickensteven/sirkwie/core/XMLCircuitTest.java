package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import com.rickensteven.sirkwie.core.parsing.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.parsing.ICircuitParser;
import com.rickensteven.sirkwie.core.parsing.XMLCircuitParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLCircuitTest
{
    @Test
    public void createSimpleCircuit()
    {
        ICircuitParser circuitParser = new XMLCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertDoesNotThrow(() -> {
            Circuit circuit = circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("XMLCircuit1.xml").getPath());

            assertTrue(circuit.getInput("A").getValue());
            assertTrue(circuit.getProbe("S").getValue());

            assertEquals(1, circuit.getInputs().size());
            assertEquals(3, circuit.getNodes().size());
            assertEquals(1, circuit.getProbes().size());
        });
    }

    @Test
    public void createSimpleInvertCircuit()
    {
        ICircuitParser circuitParser = new XMLCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertDoesNotThrow(() -> {
            Circuit circuit = circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("XMLCircuit2.xml").getPath());

            assertTrue(circuit.getInput("A").getValue());
            assertFalse(circuit.getProbe("S").getValue());

            assertEquals(1, circuit.getInputs().size());
            assertEquals(5, circuit.getNodes().size());
            assertEquals(1, circuit.getProbes().size());
        });
    }

    @Test
    public void createInvalidCircuit()
    {
        ICircuitParser circuitParser = new XMLCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertThrows(CircuitSyntaxException.class, () -> circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("CircuitValidatorNotConnected.txt").getPath()));
    }

    @Test
    public void createCircuitComplex()
    {
        ICircuitParser circuitParser = new XMLCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertDoesNotThrow(() -> {
            Circuit circuit = circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("XMLCircuit3.xml").getPath());

            assertTrue(circuit.getInput("A").getValue());
            assertTrue(circuit.getInput("B").getValue());
            assertFalse(circuit.getInput("Cin").getValue());

            assertEquals(3, circuit.getInputs().size());
            assertEquals(10, circuit.getNodes().size());
            assertEquals(2, circuit.getProbes().size());
        });
    }
}
