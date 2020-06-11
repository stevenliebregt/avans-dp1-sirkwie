package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ANTLRCircuitParserTest
{
    @Test
    public void parseTest()
    {
        @SuppressWarnings("ConstantConditions")
        String cleanTxtCircuit = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("Circuit1_FullAdder_Clean.txt")))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
        CircuitDefinition circuitDefinition = antlrCircuitParser.parse(cleanTxtCircuit);

        System.out.println(circuitDefinition.getNodes()); // TODO:
        System.out.println(circuitDefinition.getEdges()); // TODO:
    }
}
