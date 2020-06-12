package com.rickensteven.sirkwie.core.building;

import java.util.List;
import java.util.Map;

public class CircuitDefinition
{
    private final Map<String, String> nodes;
    private final Map<String, List<String>> edges;

    public CircuitDefinition(Map<String, String> nodes, Map<String, List<String>> edges)
    {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Map<String, String> getNodes()
    {
        return nodes;
    }

    public Map<String, List<String>> getEdges()
    {
        return edges;
    }
}
