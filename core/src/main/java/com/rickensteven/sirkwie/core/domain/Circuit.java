package com.rickensteven.sirkwie.core.domain;

import java.util.HashSet;
import java.util.Set;

public class Circuit
{
    private final Set<Node> nodes;
    private final Set<Node> inputs;
    private final Set<Node> probes;

    public Circuit()
    {
        this.nodes = new HashSet<>();
        this.inputs = new HashSet<>();
        this.probes = new HashSet<>();
    }

    /**
     * Adds a node to the list of nodes.
     *
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
     *
     * @param node The node to add.
     * @return The current circuit.
     * @see #addNode
     */
    public Circuit addInput(Node node)
    {
        this.inputs.add(node);
        return this.addNode(node);
    }

    /**
     * Adds a node to the list of probes, and to the list of nodes.
     *
     * @param node The node to add.
     * @return The current circuit.
     * @see #addNode
     */
    public Circuit addProbe(Node node)
    {
        this.probes.add(node);
        return this.addNode(node);
    }

    public Set<Node> getNodes()
    {
        return nodes;
    }

    public Set<Node> getInputs()
    {
        return inputs;
    }

    public Set<Node> getProbes()
    {
        return probes;
    }

    public void simulate()
    {
        probes.forEach(Node::calculate);
    }
}
