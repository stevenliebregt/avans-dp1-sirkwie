package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Node;

public interface ISimulationListener
{
    void onStartCalculate(Node node);

    void onStopCalculate(Node node, boolean calculatedValue);
}
