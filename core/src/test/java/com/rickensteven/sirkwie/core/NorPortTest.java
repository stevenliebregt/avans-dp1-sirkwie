package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NorPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NorPortTest
{
    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       0 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
            add(new Input(false));
        }};

        NorPort norPort = new NorPort(inputs);

        assertTrue(norPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         0 |       1 |      0
     */
    @Test
    public void shouldReturnOffA()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
            add(new Input(true));
        }};

        NorPort norPort = new NorPort(inputs);

        assertFalse(norPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       0 |      0
     */
    @Test
    public void shouldReturnOffB()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(true));
            add(new Input(false));
        }};

        NorPort norPort = new NorPort(inputs);

        assertFalse(norPort.calculate());
    }

    /**
     *   Input A | Input B | Output
     *  ---------|---------|--------
     *         1 |       1 |      0
     */
    @Test
    public void shouldReturnOffC()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(true));
            add(new Input(true));
        }};

        NorPort norPort = new NorPort(inputs);

        assertFalse(norPort.calculate());
    }
}
