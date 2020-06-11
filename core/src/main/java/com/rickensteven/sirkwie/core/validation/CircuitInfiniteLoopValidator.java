package com.rickensteven.sirkwie.core.validation;

import com.rickensteven.sirkwie.core.domain.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircuitInfiniteLoopValidator
{
    public boolean circuitHasInfiniteLoops(Circuit circuit)
    {
        for (Probe probe : circuit.getProbes()) {
            if (detect(probe)) return true;
        }

        return false;
    }

    private boolean detect(Probe probe)
    {
        return detect(probe, new HashSet<>());
    }

    private boolean detect(NodeComposite node, Set<Node> visitedNodes)
    {
        List<Node> parents = node.getParents();

        for (Node parent : parents) {
            if (!(parent instanceof NodeComposite)) continue; // Reached an end

            if (visitedNodes.contains(parent)) { // We have already seen this one
                return true;
            }

            Set<Node> clonedVisitedNodes = new HashSet<>(visitedNodes);
            clonedVisitedNodes.add(parent);

            if (detect((NodeComposite) parent, clonedVisitedNodes)) {
                return true;
            }
        }

        return false;
    }
}
