package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.CircuitBuilder;
import com.rickensteven.sirkwie.core.CircuitFileReader;
import com.rickensteven.sirkwie.core.domain.Circuit;

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
            Circuit circuit = circuitBuilder.build(cleanedTxtCircuit);

            System.out.println(circuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}