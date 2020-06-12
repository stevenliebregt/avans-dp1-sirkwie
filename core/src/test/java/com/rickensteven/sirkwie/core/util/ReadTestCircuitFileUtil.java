package com.rickensteven.sirkwie.core.util;

import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.building.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.parsing.ANTLRCircuitParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ReadTestCircuitFileUtil
{
    @SuppressWarnings("ConstantConditions")
    public static String read(String filePath)
    {
        return new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filePath)))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static Circuit getCircuit(String filePath)
    {
        ANTLRCircuitParser circuitParser = new ANTLRCircuitParser();
        CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
        CircuitDefinition circuitDefinition = circuitParser.parse(read(filePath));
        CircuitBuilder circuitBuilder = new CircuitBuilder();

        circuitBuilderDirector.setCircuitBuilder(circuitBuilder);
        circuitBuilderDirector.construct(circuitDefinition);

        return circuitBuilder.getCircuit();
    }
}
