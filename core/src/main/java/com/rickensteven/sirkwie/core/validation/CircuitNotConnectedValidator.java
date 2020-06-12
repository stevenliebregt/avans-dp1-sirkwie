package com.rickensteven.sirkwie.core.validation;

import com.rickensteven.sirkwie.core.building.NodeParentableVisitor;
import com.rickensteven.sirkwie.core.domain.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircuitNotConnectedValidator
{
    private NodeParentableVisitor visitor = new NodeParentableVisitor();
    private Set<Node> hasParentNodes;
    private Set<Node> isParentNodes;

    public boolean hasDisconnectedProbes(Circuit circuit)
    {
        hasParentNodes = new HashSet<>();
        isParentNodes = new HashSet<>();

        if (checkParenting(circuit)) return true;

        // TODO: Check again

        return hasParentNodes.size() != isParentNodes.size();
    }

    /**
     * Checks and stores parents on both sides of nodes.
     *
     * @param circuit The circuit to check.
     * @return true If there are any nodes without parents.
     */
    private boolean checkParenting(Circuit circuit)
    {
        for (Node node : circuit.getNodes()) {
            node.accept(visitor);

            // Skip leaf nodes
            if (!visitor.isParentable()) continue;

            // Early quit on probes
            if (node instanceof Probe && ((Probe) node).getParents().size() == 0) {
                return true;
            }

            List<Node> parents = ((NodeComposite) node).getParents();

            // Early quit on nodes without parents
            if (parents.size() == 0) {
                return true;
            } else if (!(node instanceof Probe)) {
                hasParentNodes.add(node); // Remember that this node has parents
            }

            for (Node parent : parents) {
                if (parent instanceof Input) continue;

                isParentNodes.add(parent);
            }
        }

        return false;
    }
}
