package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Circuit;
import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.NodeComposite;
import com.rickensteven.sirkwie.core.exception.NodeNotParentable;

import java.util.HashMap;

public class CircuitBuilder
{
    private CircuitDefinition circuitDefinition;
    private Circuit circuit;
    private final HashMap<String, Node> nodes = new HashMap<>();
    private final NodeParentableVisitor visitor = new NodeParentableVisitor();

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
        circuitDefinition.getNodes().forEach((key, value) -> {
            Node node = NodeFactory.getInstance().createNode(key, value);
            this.nodes.put(key, node);
            node.addToCircuit(circuit);
        });
    }

    public void buildEdges()
    {
        circuitDefinition.getEdges().forEach((nodeIdentifier, connections) -> {
            Node parentNode = this.nodes.get(nodeIdentifier);

            connections.forEach(connection -> {
                Node node = this.nodes.get(connection);
                node.accept(visitor);

                if (!visitor.isParentable()) {
                    throw new NodeNotParentable("Specified node cannot be given a parent");
                }

                NodeComposite nodeComposite = (NodeComposite) node;
                nodeComposite.add(parentNode);
            });
        });
    }
}
