package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import com.rickensteven.sirkwie.core.parsing.ANTLRCircuitParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ANTLRCircuitParserTest
{
    @SuppressWarnings("SuspiciousMethodCalls")
    @Test
    public void parseTestTwoNodesTwoEdges()
    {
        @SuppressWarnings("ConstantConditions")
        String cleanTxtCircuit = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("ThreeNodesTwoEdges.txt")))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
        CircuitDefinition circuitDefinition = antlrCircuitParser.parse(cleanTxtCircuit);

        assertEquals(3, circuitDefinition.getNodes().size());
        assertEquals(1, circuitDefinition.getEdges().size());
        assertEquals(2, circuitDefinition.getEdges().get(circuitDefinition.getEdges().keySet().toArray()[0]).size());
    }

    @Test
    public void parseTestFullCircuit()
    {
        @SuppressWarnings("ConstantConditions")
        String cleanTxtCircuit = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("Circuit1_FullAdder_Clean.txt")))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
        CircuitDefinition circuitDefinition = antlrCircuitParser.parse(cleanTxtCircuit);

        assertEquals(16, circuitDefinition.getNodes().size());
        assertEquals(14, circuitDefinition.getEdges().size());
    }

    @Test
    public void tryToParseInvalidFileThrowsSyntaxException()
    {
        String invalidFile = "This is definitely not a valid circuit file";

        assertThrows(CircuitSyntaxException.class, () -> {
            ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
            antlrCircuitParser.parse(invalidFile);
        });
    }
}
