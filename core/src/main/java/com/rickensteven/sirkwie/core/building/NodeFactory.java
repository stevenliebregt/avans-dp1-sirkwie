package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Node;

import java.util.HashMap;

public class NodeFactory
{
    private static NodeFactory instance;
    private final HashMap<String, NodeType> types = new HashMap<>()
    {
        {
            put("INPUT_HIGH", NodeType.INPUT_HIGH);
            put("INPUT_LOW", NodeType.INPUT_LOW);
            put("PROBE", NodeType.PROBE);
            put("NOT", NodeType.NOT);
            put("AND", NodeType.AND);
            put("OR", NodeType.OR);
            put("NOR", NodeType.NOR);
            put("NAND", NodeType.NAND);
            put("XOR", NodeType.XOR);
        }
    };

    // TODO error handling
    public Node createNode(String NodeTypeName)
    {
        return types.get(NodeTypeName).getInstance();
    }

    public static NodeFactory getInstance()
    {
        if (instance == null) instance = new NodeFactory();
        return instance;
    }
}
