package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.exception.CircuitInfiniteLoopException;
import com.rickensteven.sirkwie.core.exception.CircuitNotConnectedException;
import com.rickensteven.sirkwie.core.parsing.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.parsing.ICircuitParser;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircuitLoaderFacadeTest
{
    @Test
    public void antlrCircuit1FullAdder()
    {
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertDoesNotThrow(() -> {
            Circuit circuit = circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("Circuit1_FullAdder.txt").getPath());

            assertTrue(circuit.getInput("A").getValue());
            assertTrue(circuit.getInput("B").getValue());
            assertFalse(circuit.getInput("Cin").getValue());

            assertEquals(3, circuit.getInputs().size());
            assertEquals(16, circuit.getNodes().size());
            assertEquals(2, circuit.getProbes().size());
        });
    }

    @Test
    public void antlrCircuit2Decoder()
    {
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertDoesNotThrow(() -> {
            Circuit circuit = circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("Circuit2_Decoder.txt").getPath());

            assertTrue(circuit.getInput("A0").getValue());
            assertFalse(circuit.getInput("A1").getValue());
            assertFalse(circuit.getInput("A2").getValue());

            assertEquals(3, circuit.getInputs().size());
            assertEquals(22, circuit.getNodes().size());
            assertEquals(8, circuit.getProbes().size());
        });
    }

    @Test
    public void antlrCircuit3Encoder()
    {
        // TODO:
    }

    @Test
    public void antlrCircuit4InfiniteLoop()
    {
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertThrows(CircuitInfiniteLoopException.class, () -> {
            circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("Circuit4_InfiniteLoop.txt").getPath());
        });
    }

    @Test
    public void antlrCircuit5NotConnected()
    {
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertThrows(CircuitNotConnectedException.class, () -> {
            circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("Circuit5_NotConnected.txt").getPath());
        });
    }

    @Test
    public void antlrCircuit6NotConnected()
    {
        ICircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitLoaderFacade circuitLoaderFacade = new CircuitLoaderFacade(circuitParser);

        assertThrows(CircuitNotConnectedException.class, () -> {
            circuitLoaderFacade.loadCircuit(ClassLoader.getSystemResource("Circuit6_NotAllProbesReachable.txt").getPath());
        });
    }
}
