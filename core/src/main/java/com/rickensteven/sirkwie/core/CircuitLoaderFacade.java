package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Circuit;

import java.io.IOException;

public class CircuitLoaderFacade
{
    private CircuitFileReader circuitFileReader;

    public CircuitLoaderFacade()
    {
        circuitFileReader = new CircuitFileReader();
    }

    public Circuit loadCircuit(String filePath) throws IOException // TODO: More specific exception
    {
        String cleanedTxtCircuit = circuitFileReader.read(filePath);
        System.out.println(cleanedTxtCircuit);

        return null;
    }
}
