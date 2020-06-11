package com.rickensteven.sirkwie.core.building;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
=======
>>>>>>> 522f31a0468fedc4008323db3c70c7cf265a4443

import java.util.HashMap;

public class CircuitDefinition
{
    private final HashMap<String, String> nodes;
    private final HashMap<String, ArrayList<String>> edges;

    public CircuitDefinition(HashMap<String, String> nodes, HashMap<String, ArrayList<String>> edges) {
    {
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
