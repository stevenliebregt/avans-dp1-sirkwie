package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.domain.Probe;

import java.util.*;

/**
 * The propagation delay calculator should be added as a listener to the
 * target circuit. After the circuit has calculated, the propagation delay
 * can be retrieved.
 */
public class PropagationDelayCalculator implements ISimulationListener
{
    private List<PropagationNode> root;
    private Map<String, PropagationNode> history;

    @Override
    public void onStartSimulation()
    {
        root = new LinkedList<>();
        history = new LinkedHashMap<>();
    }

    @Override
    public void onStartCalculate(Node node)
    {
        String name = node.getName();

        if (history.isEmpty()) {
            history.put(name, new PropagationNode());
        } else {
            PropagationNode last = null;
            for (PropagationNode item : history.values()) last = item;

            PropagationNode newItem = new PropagationNode();

            last.children.add(newItem);
            history.put(name, newItem);
        }
    }

    @Override
    public void onStopCalculate(Node node, boolean calculatedValue)
    {
        String name = node.getName();

        if (node instanceof Probe) {
            root.add(history.get(name));
        }

        history.remove(name);
    }

    public double calculate()
    {
        double[] delays = new double[root.size()];

        for (int i = 0; i < root.size(); i++) {
            PropagationNode node = root.get(i);

            // -1 because Inputs do not count
            double delay = (calculateDepth(node) - 1) * 15;
            delays[i] = delay;
        }

        return Arrays.stream(delays).max().orElse(0);
    }

    private int calculateDepth(PropagationNode node)
    {
        if (node.children.isEmpty()) return 0;

        int maxDepth = 0;

        for (PropagationNode child : node.children) {
            maxDepth = Math.max(maxDepth, calculateDepth(child));
        }

        return maxDepth + 1;
    }

    private static class PropagationNode
    {
        List<PropagationNode> children = new ArrayList<>();
    }
}
