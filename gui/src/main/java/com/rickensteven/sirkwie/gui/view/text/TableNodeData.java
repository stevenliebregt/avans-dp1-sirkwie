package com.rickensteven.sirkwie.gui.view.text;

import com.rickensteven.sirkwie.core.domain.Node;

import java.util.ArrayList;
import java.util.List;

public class TableNodeData
{
    private final String name;
    private final String type;
    private final boolean output;
    private final List<Node> parents;

    public TableNodeData(String type, String name, boolean output, List<Node> parents)
    {
        this.name = name;
        this.type = type;
        this.output = output;
        this.parents = parents != null ? parents : new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getOutput()
    {
        return output ? "On" : "Off";
    }

    public String getParents()
    {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < parents.size(); i++) {
            b.append(parents.get(i).getName());
            if (i + 1 < parents.size()) b.append(", ");
        }
        return b.toString();
    }


}
