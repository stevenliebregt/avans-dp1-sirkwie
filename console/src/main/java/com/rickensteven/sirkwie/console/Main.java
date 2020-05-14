package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.*;
import com.rickensteven.sirkwie.core.domain.Circuit;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, world!");

        try {
            CircuitFileReader circuitFileReader = new CircuitFileReader();
            String cleanedTxtCircuit = circuitFileReader.read("Circuit1_FullAdder.txt");

            System.out.println(cleanedTxtCircuit);

            CircuitBuilder circuitBuilder = new CircuitBuilder();
            CircuitParser circuitParser = new CircuitParser();

            ICircuitBuilderDirector circuitBuilderDirector = new ANTLRCircuitBuilderDirector(circuitBuilder, circuitParser);
            circuitBuilderDirector.make(cleanedTxtCircuit);

            Circuit circuit = circuitBuilder.getCircuit();

            System.out.println(circuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}