package com.rickensteven.sirkwie.port;

import com.rickensteven.sirkwie.domain.Input;
import com.rickensteven.sirkwie.domain.Node;
import com.rickensteven.sirkwie.domain.XorPort;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XorPortTest
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

        XorPort xorPort = new XorPort(inputs);

        assertFalse(xorPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       1 |      1
     */
    @Test
    public void shouldReturnOnA()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(false));
            add(new Input(true));
        }};

        XorPort xorPort = new XorPort(inputs);

        assertTrue(xorPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       0 |      1
     */
    @Test
    public void shouldReturnOnB()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(true));
            add(new Input(false));
        }};

        XorPort xorPort = new XorPort(inputs);

        assertTrue(xorPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       1 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        Set<Node> inputs = new HashSet<Node>() {{
            add(new Input(true));
            add(new Input(true));
        }};

        XorPort xorPort = new XorPort(inputs);

        assertFalse(xorPort.calculate());
    }
}
