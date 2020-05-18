package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.*;
import com.rickensteven.sirkwie.core.building.ANTLRCircuitBuilder;
import com.rickensteven.sirkwie.core.building.ANTLRCircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.domain.Circuit;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, world!");

        try {
            CircuitFileReader circuitFileReader = new CircuitFileReader();
            String cleanedTxtCircuit = circuitFileReader.read("Circuit1_FullAdder.txt");

            // Building example TODO: Check this
            CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector();
            ANTLRCircuitParser antlrCircuitParser = new ANTLRCircuitParser();
            ANTLRCircuitBuilder antlrCircuitBuilder = new ANTLRCircuitBuilder(antlrCircuitParser);

            circuitBuilderDirector.setCircuitBuilder(antlrCircuitBuilder);
            circuitBuilderDirector.construct(cleanedTxtCircuit);

            Circuit circuit = antlrCircuitBuilder.getCircuit();

            System.out.println(circuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}