package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.parsing.ICircuitParser;
import com.rickensteven.sirkwie.core.parsing.XMLCircuitParser;
import com.rickensteven.sirkwie.core.util.ReadTestCircuitFileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLCircuitParserTest
{
    @Test
    public void parseCircuit1()
    {
        String input = ReadTestCircuitFileUtil.read("XMLCircuit1.xml");
        ICircuitParser circuitParser = new XMLCircuitParser();

        assertDoesNotThrow(() -> {
            CircuitDefinition circuitDefinition = circuitParser.parse(input);

            assertEquals(3, circuitDefinition.getNodes().size());
            assertEquals(2, circuitDefinition.getEdges().size());
        });
    }
}
