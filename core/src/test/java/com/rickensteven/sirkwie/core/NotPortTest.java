package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NotPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotPortTest
{
    @Test
    public void shouldThrowErrorNotOneInput()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
            add(new Input(false));
        }};

        assertThrows(IllegalArgumentException.class, () -> new NotPort(inputs));
    }

    /**
     *   Input A | Output
     *  ---------|--------
     *         0 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        List<Node> inputs = new ArrayList<Node>() {{
            add(new Input(false));
        }};

        NotPort notPort = new NotPort(inputs);

        assertTrue(notPort.calculate());
    }

    /**
     *   Input A | Output
     *  ---------|--------
     *         1 |      0
     */
    @Test
    public void shouldReturnOff()
    {
        List<Node> inputs = new ArrayList<Node>()
        {{
            add(new Input(true));
        }};

        NotPort notPort = new NotPort(inputs);

        assertFalse(notPort.calculate());
    }
}
