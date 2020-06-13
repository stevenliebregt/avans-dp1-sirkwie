package com.rickensteven.sirkwie.core.parsing;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CircuitParserFactoryTest
{
    @Test
    void getCircuitParser()
    {
        CircuitParserFactory circuitParserFactory = new CircuitParserFactory();

        assertEquals(new HashSet<>() {{
            add("ANTLR");
            add("XML");
        }}, circuitParserFactory.circuitParserNames);

        assertTrue(circuitParserFactory.getCircuitParser("ANTLR") instanceof ANTLRCircuitParser);
        assertTrue(circuitParserFactory.getCircuitParser("XML") instanceof XMLCircuitParser);
    }
}