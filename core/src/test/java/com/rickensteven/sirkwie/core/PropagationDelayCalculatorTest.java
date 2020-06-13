package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Input;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NotGate;
import com.rickensteven.sirkwie.core.domain.Probe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropagationDelayCalculatorTest
{
    @Test
    void calculate()
    {
        PropagationDelayCalculator propagationDelayCalculator = new PropagationDelayCalculator();

        Probe s = new Probe("S");
        Node node1 = new NotGate("NODE1");
        Node node2 = new NotGate("NODE2");
        Input input = new Input(true, "I");

        propagationDelayCalculator.onStartCalculate(s);
        propagationDelayCalculator.onStartCalculate(node1);
        propagationDelayCalculator.onStartCalculate(node2);
        propagationDelayCalculator.onStartCalculate(input);
        propagationDelayCalculator.onStopCalculate(input, false);
        propagationDelayCalculator.onStopCalculate(node2, false);
        propagationDelayCalculator.onStopCalculate(node1, false);
        propagationDelayCalculator.onStopCalculate(s, false);

        // 30 because we have 2 nodes
        assertEquals(30, propagationDelayCalculator.calculate());
    }
}