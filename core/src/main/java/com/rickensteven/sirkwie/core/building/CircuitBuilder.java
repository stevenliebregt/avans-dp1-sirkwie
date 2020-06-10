package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NodeComposite;

import java.util.HashMap;

public class CircuitBuilder
{
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

    public void buildNodes()
    {
        //TODO error handling
        System.out.println("I should build nodes");
        System.out.println(circuitDefinition.getNodes());
        circuitDefinition.getNodes().forEach((key, value) -> {
            Node node = NodeFactory.GetInstance().CreateNode(value);
            this.nodes.put(key, node);
            // TODO how to add as input or probe? how do you know? better than this??
            this.addToCircuit(node, value);
        });
    }

    private void addToCircuit(Node node, String value) {
        switch (value) {
            case "INPUT_HIGH":
                circuit.addInput(node);
            case "INPUT_LOW":
                circuit.addInput(node);
            case "PROBE":
                circuit.addProbe(node);
            default:
                circuit.addNode(node);
        }
    }

    public void buildEdges()
    {
        //TODO error handling
        System.out.println("I should build edges");
        System.out.println(circuitDefinition.getEdges());
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
