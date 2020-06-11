package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NotGate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotGateTest
{
    /**
     * Input A | Output
     * ---------|--------
     * 0 |      1
     */
    @Test
    public void shouldReturnOn()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(false, "A"));
        }};

        NotGate notGate = new NotGate(inputs, "N");
        notGate.calculate();

        assertTrue(notGate.getValue());
    }

    /**
     * Input A | Output
     * ---------|--------
     * 1 |      0
     */
    @Test
    public void shouldReturnOff()
    {
        List<Node> inputs = new ArrayList<>()
        {{
            add(new Input(true, "I"));
        }};

        NotGate notGate = new NotGate(inputs, "N");
        notGate.calculate();

        assertFalse(notGate.getValue());
    }

    @Test
    public void moreThanOneParentShouldThrowException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Node> inputs = new ArrayList<>()
            {{
                add(new Input(false, "A"));
                add(new Input(false, "B"));
            }};

            new NotGate(inputs, "I");
        });
    }
}
