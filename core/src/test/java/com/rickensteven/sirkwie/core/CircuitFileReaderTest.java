package com.rickensteven.sirkwie.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircuitFileReaderTest
{
    @Test
    public void readFile()
    {
        String filePath = ClassLoader.getSystemResource("Circuit1_FullAdder.txt").getPath();

        CircuitFileReader circuitFileReader = new CircuitFileReader();

        assertDoesNotThrow(() -> {
            String cleanedTxtCircuit = circuitFileReader.read(filePath);

            assertNotNull(cleanedTxtCircuit);
            assertFalse(cleanedTxtCircuit.contains("#"));
        });
    }
}
