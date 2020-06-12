package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.building.NodeParentableVisitor;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Probe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeParentableVisitorTest
{
    private NodeParentableVisitor nodeParentableVisitor = new NodeParentableVisitor();

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
        Input input = new Input(false, "I");
        input.accept(nodeParentableVisitor);

        assertFalse(nodeParentableVisitor.isParentable());
    }
}
