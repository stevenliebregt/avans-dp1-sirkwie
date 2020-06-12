package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.NodeParentableVisitor;
import com.rickensteven.sirkwie.core.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeParentableVisitorTest
{
    private final NodeParentableVisitor nodeParentableVisitor = new NodeParentableVisitor();

    @Test
    public void probe()
    {
        Probe probe = new Probe("A");
        probe.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void input()
    {
        Input input = new Input(false, "A");
        input.accept(nodeParentableVisitor);

        assertFalse(nodeParentableVisitor.isParentable());
    }

    @Test
    public void andGate()
    {
        AndGate andGate = new AndGate("A");
        andGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void nAndGate()
    {
        NAndGate nAndGate = new NAndGate("A");
        nAndGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void norGate()
    {
        NOrGate nOrGate = new NOrGate("A");
        nOrGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void notGate()
    {
        NotGate notGate = new NotGate("A");
        notGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void orGate()
    {
        OrGate orGate = new OrGate("A");
        orGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }

    @Test
    public void xOrGate()
    {
        XOrGate xOrGate = new XOrGate("A");
        xOrGate.accept(nodeParentableVisitor);

        assertTrue(nodeParentableVisitor.isParentable());
    }
}
