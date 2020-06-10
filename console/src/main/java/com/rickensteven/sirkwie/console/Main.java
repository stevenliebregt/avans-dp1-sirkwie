package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.*;
import com.rickensteven.sirkwie.core.building.*;
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
            ICircuitParser antlrCircuitParser = new ANTLRCircuitParser();
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