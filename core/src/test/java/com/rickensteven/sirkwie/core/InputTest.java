package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputTest
{
    @Test
    public void shouldBeOn()
    {
        Input input = new Input(true, "A");
        input.calculate();

        assertTrue(input.getValue());
    }

    @Test
    public void shouldBeOff()
    {
        Input input = new Input(false, "B");
        input.calculate();

        assertFalse(input.getValue());
    }
}
