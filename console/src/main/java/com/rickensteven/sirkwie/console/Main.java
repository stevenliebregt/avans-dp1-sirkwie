package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.CircuitBuilder;
import com.rickensteven.sirkwie.core.CircuitBuilderDirector;
import com.rickensteven.sirkwie.core.CircuitFileReader;
import com.rickensteven.sirkwie.core.CircuitParser;
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
            ParseTree parseTree = circuitParser.parse(cleanedTxtCircuit);

            CircuitBuilderDirector circuitBuilderDirector = new CircuitBuilderDirector(circuitBuilder);
            circuitBuilderDirector.make(cleanedTxtCircuit);
            Circuit circuit = circuitBuilder.getCircuit();

            System.out.println(circuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}