package com.rickensteven.sirkwie.core.domain;

import com.rickensteven.sirkwie.core.ISimulationListener;

import java.util.*;

public class Circuit
{
    private final Set<Node> nodes;
    private final Set<Input> inputs;
    private final Set<Probe> probes;

    public Circuit()
    {
        nodes = new LinkedHashSet<>();
        inputs = new LinkedHashSet<>();
        probes = new LinkedHashSet<>();
    }

    public void addSimulationListener(ISimulationListener simulationListener)
    {
        nodes.forEach(node -> node.addSimulationListener(simulationListener));
    }

    public void addSimulationListeners(Collection<ISimulationListener> simulationListeners)
    {
        simulationListeners.forEach(this::addSimulationListener);
    }

    /**
     * Adds a node to the list of nodes.
     *
     * @param node The node to add.
     */
    public void addNode(Node node)
    {
        this.nodes.add(node);
    }

    /**
     * Adds a node to the list of inputs, and to the list of nodes.
     *
     * @param node The node to add.
     * @see #addNode
     */
    public void addInput(Input node)
    {
        this.inputs.add(node);
        this.addNode(node);
    }

    /**
     * Adds a node to the list of probes, and to the list of nodes.
     *
     * @param node The node to add.
     * @see #addNode
     */
    public void addProbe(Probe node)
    {
        this.probes.add(node);
        this.addNode(node);
    }

    public Set<Node> getNodes()
    {
        return nodes;
    }

    public Set<Input> getInputs()
    {
        return inputs;
    }

    public Set<Probe> getProbes()
    {
        return probes;
    }

    public Input getInput(String name)
    {
        return this.inputs
                .stream()
                .filter(node -> node.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Probe getProbe(String name)
    {
        return this.probes
                .stream()
                .filter(node -> node.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void simulate()
    {
        probes.forEach(Node::calculate);
    }
}
