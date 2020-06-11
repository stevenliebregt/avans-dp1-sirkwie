package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.INodeVisitor;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.Probe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest
{
    @Test
    public void shouldBeOn()
    {
        List<Node> inputs = new ArrayList<Node>()
        {{
            add(new Node("N")
            {
                @Override
                public boolean calculate()
                {
                    return true;
                }

                @Override
                public void accept(INodeVisitor nodeVisitor)
                {

                }
            });
        }};

        Probe probe = new Probe(inputs, "P");
        probe.calculate();

        assertTrue(probe.getValue());
    }

    @Test
    public void shouldBeOff()
    {
        List<Node> inputs = new ArrayList<Node>()
        {{
            add(new Node("I")
            {
                @Override
                public boolean calculate()
                {
                    return false;
                }

                @Override
                public void accept(INodeVisitor nodeVisitor)
                {

                }
            });
        }};

        Probe probe = new Probe(inputs, "P");
        probe.calculate();

        assertFalse(probe.getValue());
    }

    @Test
    public void moreThanOneParentShouldThrowException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Node> inputs = new ArrayList<Node>()
            {{
                add(new Input(false, "A"));
                add(new Input(false, "B"));
            }};

            new Probe(inputs, "P");
        });
    }
}
