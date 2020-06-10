package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.*;
import com.rickensteven.sirkwie.core.building.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitBuilder;
import com.rickensteven.sirkwie.core.building.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.domain.Circuit;

public class Main
{
    public static void main(String[] args)
    {
        try {
            CircuitFileReader circuitFileReader = new CircuitFileReader();
            String cleanedTxtCircuit = circuitFileReader.read("Circuit1_FullAdder.txt");

            // Building example TODO: Check this
            CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
            ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
            CircuitDefinition circuitDefinition = antlrCircuitParser.parse(cleanedTxtCircuit);
            CircuitBuilder circuitBuilder = new CircuitBuilder();

            circuitBuilderDirector.setCircuitBuilder(circuitBuilder);
            circuitBuilderDirector.construct(circuitDefinition);

            Circuit circuit = circuitBuilder.getCircuit();

            System.out.println(circuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}