package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.XOrGate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XOrGateTest
{
    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 0 |       0 |      0
     */
    @Test
    public void shouldReturnOffA()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
            add(new Input(false, "B"));
        }};

        XOrGate XOrGate = new XOrGate(inputs, "X");
        XOrGate.calculate();

        assertFalse(XOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 0 |       1 |      1
     */
    @Test
    public void shouldReturnOnA()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
            add(new Input(true, "B"));
        }};

        XOrGate XOrGate = new XOrGate(inputs, "X");
        XOrGate.calculate();

        assertTrue(XOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       0 |      1
     */
    @Test
    public void shouldReturnOnB()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(false, "B"));
        }};

        XOrGate XOrGate = new XOrGate(inputs, "X");
        XOrGate.calculate();

        assertTrue(XOrGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       1 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(true, "B"));
        }};

        XOrGate XOrGate = new XOrGate(inputs, "X");
        XOrGate.calculate();

        assertFalse(XOrGate.getValue());
    }
}
