package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CircuitNotConnectedValidator
{
    public boolean hasDisconnectedProbes(Circuit circuit)
    {
        List<Boolean> probesConnected = new ArrayList<>();

        for (Probe probe: circuit.getProbes()) {
            if (probe.getParents().size() == 0) {
                probesConnected.add(false);
                continue;
            };

            boolean reaches = false;

            for (Node node : probe.getParents()) {
                if (reaches) continue;

                if (isOrReachesInput(node)) {
                    reaches = true;
                    probesConnected.add(true);
                } else {
                    probesConnected.add(false);
                }
            }
        }

        return probesConnected.contains(false);
    }

    private boolean isOrReachesInput(Node node)
    {
        if (node instanceof Input) return true;

        if (node instanceof NodeComposite) {
            for (Node parent : ((NodeComposite) node).getParents()) {
                if (isOrReachesInput(parent)) return true;
            }
        }

        return false;
    }
}
