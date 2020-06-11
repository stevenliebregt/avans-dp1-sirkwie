package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.NodeFactory;
import com.rickensteven.sirkwie.core.domain.*;
import com.rickensteven.sirkwie.core.exception.NodeTypeUnknownException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeFactoryTest
{
    private final NodeFactory nodeFactory = NodeFactory.getInstance();

    @Test
    public void shouldReturnNotGate()
    {
        assertTrue(nodeFactory.createNode("N", "NOT") instanceof NotGate);
    }

    @Test
    public void shouldReturnAndGate()
    {
        assertTrue(nodeFactory.createNode("A", "AND") instanceof AndGate);
    }

    @Test
    public void shouldReturnOrGate()
    {
        assertTrue(nodeFactory.createNode("O", "OR") instanceof OrGate);
    }

    @Test
    public void shouldReturnNorGate()
    {
        assertTrue(nodeFactory.createNode("NO", "NOR") instanceof NOrGate);
    }

    @Test
    public void shouldReturnNandGate()
    {
        assertTrue(nodeFactory.createNode("NA", "NAND") instanceof NAndGate);
    }

    @Test
    public void shouldReturnXorGate()
    {
        assertTrue(nodeFactory.createNode("X", "XOR") instanceof XOrGate);
    }

    @Test
    public void shouldReturnInputHigh()
    {
        Node inputHigh = nodeFactory.createNode("A", "INPUT_HIGH");

        assertTrue(inputHigh instanceof Input);
        assertTrue(inputHigh.getValue());
    }

    @Test
    public void shouldReturnInputLow()
    {
        Node inputLow = nodeFactory.createNode("A", "INPUT_LOW");

        assertTrue(inputLow instanceof Input);
        assertFalse(inputLow.getValue());
    }

    @Test
    public void shouldReturnProbe()
    {
        assertTrue(nodeFactory.createNode("P", "PROBE") instanceof Probe);
    }

    @Test
    public void shouldThrowError()
    {
        assertThrows(NodeTypeUnknownException.class, () -> {
            nodeFactory.createNode("DOES NOT EXIST", "DOES NOT EXIST");
        });
    }
}
