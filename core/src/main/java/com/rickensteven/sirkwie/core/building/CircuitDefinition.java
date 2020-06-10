package com.rickensteven.sirkwie.core.building;
import java.util.ArrayList;
import java.util.HashMap;

public class CircuitDefinition {

    private final HashMap<String, String> nodes;
    private final HashMap<String, ArrayList<String>> edges;

    public CircuitDefinition(HashMap<String, String> nodes, HashMap<String, ArrayList<String>> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public HashMap<String, String> getNodes()
    {
        return nodes;
    }

    public HashMap<String, ArrayList<String>> getEdges()
    {
        return edges;
    }
}
