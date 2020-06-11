package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Node;
import com.rickensteven.sirkwie.core.exception.NodeTypeUnknownException;

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

    public Node createNode(String nodeTypeName)
    {
        if (types.containsKey(nodeTypeName)) {
            throw new NodeTypeUnknownException("File contains unknown node types");
        }
        return types.get(nodeTypeName).getInstance();
    }

    public static NodeFactory getInstance()
    {
        if (instance == null) instance = new NodeFactory();
        return instance;
    }
}
