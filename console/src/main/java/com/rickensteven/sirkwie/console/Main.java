package com.rickensteven.sirkwie.console;

import com.rickensteven.sirkwie.core.CircuitFileReader;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, world!");

        try {
            CircuitFileReader circuitFileReader = new CircuitFileReader();
            String cleanedTxtCircuit = circuitFileReader.read("Circuit1_FullAdder.txt");

            System.out.println(cleanedTxtCircuit);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}