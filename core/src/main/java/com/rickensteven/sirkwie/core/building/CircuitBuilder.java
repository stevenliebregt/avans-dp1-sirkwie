package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NodeComposite;

import java.util.HashMap;

public class CircuitBuilder
{
    // TODO: Deze class, of een validator zou de CircuitInfiniteLoopException en CircuitNotConnectedException moeten gaan gooien

    private CircuitDefinition circuitDefinition;
    private Circuit circuit;
    private final HashMap<String, Node> nodes = new HashMap<>();

    public Circuit getCircuit()
    {
        return circuit;
    }

    public void reset(CircuitDefinition circuitDefinition)
    {
        this.circuitDefinition = circuitDefinition;
        circuit = new Circuit();
    }

    //TODO error handling
    public void buildNodes()
    {
        circuitDefinition.getNodes().forEach((key, value) -> {
            Node node = NodeFactory.getInstance().createNode(value);
            this.nodes.put(key, node);
            node.addToCircuit(circuit);
        });
    }

    //TODO error handling
    public void buildEdges()
    {
        circuitDefinition.getEdges().forEach((key, value) -> {
            Node parentNode = this.nodes.get(key);
            value.forEach(child -> {
                // TODO casting not nice?
                NodeComposite nodeComposite = (NodeComposite) this.nodes.get(child);
                nodeComposite.add(parentNode);
            });
        });
    }
}
