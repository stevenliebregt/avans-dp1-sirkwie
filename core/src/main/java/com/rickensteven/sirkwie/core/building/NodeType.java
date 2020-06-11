package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

public enum NodeType
{
    INPUT_HIGH("INPUT_HIGH") {
        @Override
        public Node getInstance()
        {
            return new Input(true);
        }
    },
    INPUT_LOW("INPUT_LOW") {
        @Override
        public Node getInstance()
        {
            return new Input(false);
        }
    },
    PROBE("PROBE") {
        @Override
        public Node getInstance()
        {
            return new Probe();
        }
    },
    AND("AND") {
        @Override
        public Node getInstance()
        {
            return new AndGate(null);
        }
    },
    OR("OR") {
        @Override
        public Node getInstance()
        {
            return new OrGate(null);
        }
    },
    NOT("NOT") {
        @Override
        public Node getInstance()
        {
            return new NotGate(null);
        }
    },
    NOR("NOR") {
        @Override
        public Node getInstance()
        {
            return new NOrGate(null);
        }
    },
    XOR("XOR") {
        @Override
        public Node getInstance()
        {
            return new XOrGate(null);
        }
    },
    NAND("NAND") {
        @Override
        public Node getInstance()
        {
            return new NAndGate(null);
        }
    };

    NodeType(String type)
    {
    }

    public abstract Node getInstance();
}
