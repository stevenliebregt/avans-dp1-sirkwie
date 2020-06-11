package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.NodeFactory;
import com.rickensteven.sirkwie.core.domain.*;
import com.rickensteven.sirkwie.core.exception.NodeTypeUnknownException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeFactoryTest
{
    private NodeFactory nodeFactory = NodeFactory.getInstance();

    @Test
    public void shouldReturnNotGate()
    {
        assertTrue(nodeFactory.createNode("NOT") instanceof NotGate);
    }

    @Test
    public void shouldReturnAndGate()
    {
        assertTrue(nodeFactory.createNode("AND") instanceof AndGate);
    }

    @Test
    public void shouldReturnOrGate()
    {
        assertTrue(nodeFactory.createNode("OR") instanceof OrGate);
    }

    @Test
    public void shouldReturnNorGate()
    {
        assertTrue(nodeFactory.createNode("NOR") instanceof NOrGate);
    }

    @Test
    public void shouldReturnNandGate()
    {
        assertTrue(nodeFactory.createNode("NAND") instanceof NAndGate);
    }

    @Test
    public void shouldReturnXorGate()
    {
        assertTrue(nodeFactory.createNode("XOR") instanceof XOrGate);
    }

    @Test
    public void shouldReturnInputHigh()
    {
        Node inputHigh = nodeFactory.createNode("INPUT_HIGH");

        assertTrue(inputHigh instanceof Input);
        assertTrue(inputHigh.getValue());
    }

    @Test
    public void shouldReturnInputLow()
    {
        Node inputLow = nodeFactory.createNode("INPUT_LOW");

        assertTrue(inputLow instanceof Input);
        assertFalse(inputLow.getValue());
    }

    @Test
    public void shouldReturnProbe()
    {
        assertTrue(nodeFactory.createNode("PROBE") instanceof Probe);
    }

    @Test
    public void shouldThrowError()
    {
        assertThrows(NodeTypeUnknownException.class, () -> {
            nodeFactory.createNode("DOES NOT EXIST");
        });
    }
}
