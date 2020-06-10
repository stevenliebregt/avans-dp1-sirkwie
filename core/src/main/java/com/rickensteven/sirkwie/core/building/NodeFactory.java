package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class NodeFactory
{
    private static NodeFactory _instance;
    private final HashMap<String, Class<? extends Node>> _types;

    private NodeFactory() {
        _types = new HashMap<>()
        {
            {
                put("INPUT_HIGH", Input.class);
                put("INPUT_LOW", Input.class);
                put("PROBE", Probe.class);
                put("NOT", NotGate.class);
                put("AND", AndGate.class);
                put("OR", OrGate.class);
            }
        };
    }

    // TODO error handling
    public Node CreateNode(String typeName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        //TODO not sure if this works because constructor is empty for only some classes
        return _types.get(typeName).getConstructor().newInstance();
    }

    public static NodeFactory GetInstance() {
        if(_instance == null) _instance = new NodeFactory();
        return _instance;
    }
}
