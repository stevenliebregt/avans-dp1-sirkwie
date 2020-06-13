package com.rickensteven.sirkwie.core.parsing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CircuitParserFactory
{
    private final Map<String, ICircuitParser> circuitParsers;
    public final Set<String> circuitParserNames;

    public CircuitParserFactory()
    {
        circuitParsers = new HashMap<>() {{
            put("ANTLR", new ANTLRCircuitParser());
            put("XML", new XMLCircuitParser());
        }};
        circuitParserNames = circuitParsers.keySet();
    }

    public ICircuitParser getCircuitParser(String name)
    {
        return circuitParserNames.contains(name) ? circuitParsers.get(name) : null;
    }
}
