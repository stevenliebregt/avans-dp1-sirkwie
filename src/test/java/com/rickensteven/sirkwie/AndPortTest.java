package com.rickensteven.sirkwie;

import com.rickensteven.sirkwie.domain.AndPort;
import com.rickensteven.sirkwie.domain.Input;
import com.rickensteven.sirkwie.domain.Node;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndPortTest
{
    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       0 |      0
     */
    @Test
    public void shouldReturnOffA()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(false));
            add(new Input(false));
        }};

        AndPort andPort = new AndPort(inputs);

        assertFalse(andPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       1 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(false));
            add(new Input(true));
        }};

        AndPort andPort = new AndPort(inputs);

        assertFalse(andPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       0 |      0
     */
    @Test
    public void shouldReturnOffC()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(true));
            add(new Input(false));
        }};

        AndPort andPort = new AndPort(inputs);

        assertFalse(andPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       1 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(true));
            add(new Input(true));
        }};

        AndPort andPort = new AndPort(inputs);

        assertTrue(andPort.calculate());
    }
}
