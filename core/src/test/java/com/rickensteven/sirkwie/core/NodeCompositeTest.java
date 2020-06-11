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
        NodeComposite nodeComposite = new Probe();

        assertEquals(0, nodeComposite.getParents().size());

        nodeComposite.add(new Input(false));

        assertEquals(1, nodeComposite.getParents().size());
    }

    @Test
    public void removeParent()
    {
        NodeComposite nodeComposite = new Probe();
        Input input = new Input(false);

        nodeComposite.add(input);

        assertEquals(1, nodeComposite.getParents().size());

        nodeComposite.remove(input);

        assertEquals(0, nodeComposite.getParents().size());
    }
}
