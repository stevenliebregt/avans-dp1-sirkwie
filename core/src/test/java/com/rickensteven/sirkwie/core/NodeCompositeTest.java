package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.NodeComposite;
import com.rickensteven.sirkwie.core.domain.Probe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeCompositeTest
{
    @Test
    public void addParent()
    {
        NodeComposite nodeComposite = new Probe("P");

        assertEquals(0, nodeComposite.getParents().size());

        nodeComposite.add(new Input(false, "I"));

        assertEquals(1, nodeComposite.getParents().size());
    }

    @Test
    public void removeParent()
    {
        NodeComposite nodeComposite = new Probe("P");
        Input input = new Input(false, "A");

        nodeComposite.add(input);

        assertEquals(1, nodeComposite.getParents().size());

        nodeComposite.remove(input);

        assertEquals(0, nodeComposite.getParents().size());
    }
}
