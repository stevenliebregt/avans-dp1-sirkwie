package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.NOrGate;
import com.rickensteven.sirkwie.core.domain.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NOrGateTest
{
    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 0 |       0 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
            add(new Input(false, "B"));
        }};

        NOrGate NOrGate = new NOrGate(inputs, "N");
        NOrGate.calculate();

        assertTrue(NOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 0 |       1 |      0
     */
    @Test
    public void shouldReturnOffA()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
            add(new Input(true, "B"));
        }};

        NOrGate NOrGate = new NOrGate(inputs, "N");
        NOrGate.calculate();

        assertFalse(NOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       0 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(false, "B"));
        }};

        NOrGate NOrGate = new NOrGate(inputs, "N");
        NOrGate.calculate();

        assertFalse(NOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       1 |      0
     */
    @Test
    public void shouldReturnOffC()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(true, "B"));
        }};

        NOrGate NOrGate = new NOrGate(inputs, "N");
        NOrGate.calculate();

        assertFalse(NOrGate.getValue());
    }
}
