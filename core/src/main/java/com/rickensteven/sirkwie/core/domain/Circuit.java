package com.rickensteven.sirkwie.core.domain;

import java.util.Set;

public class Circuit
{
    private Set<Node> nodes;
    private Set<Node> inputs;
    private Set<Node> probes;

    public Circuit(Set<Node> nodes, Set<Node> inputs, Set<Node> probes)
    {
        this.nodes = nodes;
        this.inputs = inputs;
        this.probes = probes;
    }

    /**
     * Adds a node to the list of nodes.
     * @param node The node to add.
     * @return The current circuit.
     */
    public Circuit addNode(Node node)
    {
        this.nodes.add(node);
        return this;
    }

    /**
     * Adds a node to the list of inputs, and to the list of nodes.
     * @see #addNode
     * @param node The node to add.
     * @return The current circuit.
     */
    public Circuit addInput(Node node)
    {
        this.inputs.add(node);
        return this.addNode(node);
    }

    /**
     * Adds a node to the list of probes, and to the list of nodes.
     * @see #addNode
     * @param node The node to add.
     * @return The current circuit.
     */
    public Circuit addProbe(Node node)
    {
        this.probes.add(node);
        return this.addNode(node);
    }

    public void simulate()
    {
        // TODO:
    }
}
