package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.AndGate;
import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndGateTest
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

        AndGate andGate = new AndGate(inputs, "G");
        andGate.calculate();

        assertFalse(andGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 0 |       1 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
            add(new Input(true, "B"));
        }};

        AndGate andGate = new AndGate(inputs, "G");
        andGate.calculate();

        assertFalse(andGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       0 |      0
     */
    @Test
    public void shouldReturnOffC()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(false, "B"));
        }};

        AndGate andGate = new AndGate(inputs, "G");
        andGate.calculate();

        assertFalse(andGate.getValue());
    }

    /**
     * Input A | Input B | Output
     * ---------|---------|--------
     * 1 |       1 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "A"));
            add(new Input(true, "B"));
        }};

        AndGate andGate = new AndGate(inputs, "G");
        andGate.calculate();

        assertTrue(andGate.getValue());
    }
}
