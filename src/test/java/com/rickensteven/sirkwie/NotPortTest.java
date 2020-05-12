package com.rickensteven.sirkwie;

import com.rickensteven.sirkwie.domain.Input;
import com.rickensteven.sirkwie.domain.Node;
import com.rickensteven.sirkwie.domain.NotPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotPortTest
{
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
