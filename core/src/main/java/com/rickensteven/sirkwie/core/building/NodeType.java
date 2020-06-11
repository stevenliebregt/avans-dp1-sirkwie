package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

public enum NodeType
{
    INPUT_HIGH("INPUT_HIGH") {
        @Override
        public Node getInstance(String name)
        {
            return new Input(true, name);
        }
    },
    INPUT_LOW("INPUT_LOW") {
        @Override
        public Node getInstance(String name)
        {
            return new Input(false, name);
        }
    },
    PROBE("PROBE") {
        @Override
        public Node getInstance(String name)
        {
            return new Probe(name);
        }
    },
    AND("AND") {
        @Override
        public Node getInstance(String name)
        {
            return new AndGate(name);
        }
    },
    OR("OR") {
        @Override
        public Node getInstance(String name)
        {
            return new OrGate(name);
        }
    },
    NOT("NOT") {
        @Override
        public Node getInstance(String name)
        {
            return new NotGate(name);
        }
    },
    NOR("NOR") {
        @Override
        public Node getInstance(String name)
        {
            return new NOrGate(name);
        }
    },
    XOR("XOR") {
        @Override
        public Node getInstance(String name)
        {
            return new XOrGate(name);
        }
    },
    NAND("NAND") {
        @Override
        public Node getInstance(String name)
        {
            return new NAndGate(name);
        }
    };

    NodeType(String type)
    {
    }

    public abstract Node getInstance(String name);
}
