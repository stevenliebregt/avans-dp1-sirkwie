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
    /**
     *   Input A | Output
     *  ---------|--------
     *         0 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        Node input = new Input(false);

        NotPort notPort = new NotPort(input);
        notPort.calculate();

        assertTrue(notPort.getValue());
    }

    /**
     *   Input A | Output
     *  ---------|--------
     *         1 |      0
     */
    @Test
    public void shouldReturnOff()
    {
        Node input = new Input(true);

        NotPort notPort = new NotPort(input);
        notPort.calculate();

        assertFalse(notPort.getValue());
    }
}
