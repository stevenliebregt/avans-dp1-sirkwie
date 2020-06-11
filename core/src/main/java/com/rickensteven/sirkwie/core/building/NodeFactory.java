package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.Node;

import java.util.HashMap;

public class NodeFactory
{
    private static NodeFactory _instance;
    private final HashMap<String, NodeType> _types;

    private NodeFactory()
    {
        _types = new HashMap<>()
        {
            {
                put("INPUT_HIGH", NodeType.INPUT_HIGH);
                put("INPUT_LOW", NodeType.INPUT_LOW);
                put("PROBE", NodeType.PROBE);
                put("NOT", NodeType.NOT);
                put("AND", NodeType.AND);
                put("OR", NodeType.XOR);
                put("NOR", NodeType.NOR);
                put("NAND", NodeType.NAND);
                put("XOR", NodeType.XOR);
            }
        };
    }

    // TODO error handling
    public Node CreateNode(String NodeTypeName)
    {
        return _types.get(NodeTypeName).getInstance();
    }

    public static NodeFactory GetInstance()
    {
        if (_instance == null) _instance = new NodeFactory();
        return _instance;
    }
}
