package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.NandPort;
import com.rickensteven.sirkwie.core.domain.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NandPortTest
{
    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       0 |      1
     */
    @Test
    public void shouldReturnOnA()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
            add(new Input(false));
        }};

        NandPort nandPort = new NandPort(inputs);

        assertTrue(nandPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       1 |      1
     */
    @Test
    public void shouldReturnOnB()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
            add(new Input(true));
        }};

        NandPort nandPort = new NandPort(inputs);

        assertTrue(nandPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       0 |      1
     */
    @Test
    public void shouldReturnOnC()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(true));
            add(new Input(false));
        }};

        NandPort nandPort = new NandPort(inputs);

        assertTrue(nandPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       1 |      0
     */
    @Test
    public void shouldReturnOff()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(true));
            add(new Input(true));
        }};

        NandPort nandPort = new NandPort(inputs);

        assertFalse(nandPort.calculate());
    }
}
