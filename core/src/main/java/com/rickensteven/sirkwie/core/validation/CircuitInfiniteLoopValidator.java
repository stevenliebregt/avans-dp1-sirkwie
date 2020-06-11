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
            if (detectCycleForProbe(probe)) return true;
        }

        return false;
    }

    private boolean detectCycleForProbe(Probe probe)
    {
        CycleDetector cycleDetector = new CycleDetector();
        cycleDetector.detect(probe);

        return cycleDetector.hasCycle();
    }

    private static class CycleDetector
    {
        private boolean hasCycle = false;

        public boolean hasCycle()
        {
            return hasCycle;
        }

        public void detect(Probe probe)
        {
            List<Node> parents = probe.getParents();

            for (Node parent : parents) {
                if (!(parent instanceof NodeComposite)) continue; // Reached an end

                Set<Node> visitedNodes = new HashSet<>();
                visitedNodes.add(probe);
                visitedNodes.add(parent);

                if (detectRecursive((NodeComposite) parent, visitedNodes)) {
                    hasCycle = true;
                    return;
                }
            }
        }

        private boolean detectRecursive(NodeComposite node, Set<Node> visitedNodes)
        {
            List<Node> parents = node.getParents();

            for (Node parent : parents) {
                if (!(parent instanceof NodeComposite)) continue; // Reached an end

                if (visitedNodes.contains(parent)) { // We have already seen this one
                    return true;
                }

                Set<Node> clonedVisitedNodes = new HashSet<>(visitedNodes);
                clonedVisitedNodes.add(parent);

                if (detectRecursive((NodeComposite) parent, clonedVisitedNodes)) {
                    return true;
                }
            }

            return false;
        }
    }
}
