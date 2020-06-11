package com.rickensteven.sirkwie.core.building;

import java.util.HashMap;
import java.util.List;

public class CircuitDefinition
{
    private final HashMap<String, String> nodes;
    private final HashMap<String, List<String>> edges;

    public CircuitDefinition(HashMap<String, String> nodes, HashMap<String, List<String>> edges)
    {
        this.nodes = nodes;
        this.edges = edges;
    }

    public HashMap<String, String> getNodes()
    {
        return nodes;
    }

    public HashMap<String, List<String>> getEdges()
    {
        return edges;
    }
}
