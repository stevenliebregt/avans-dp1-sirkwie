package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.domain.*;

public enum NodeType
{
    INPUT_HIGH() {
        @Override
        public Node getInstance(String name)
        {
            return new Input(true, name);
        }
    },
    INPUT_LOW() {
        @Override
        public Node getInstance(String name)
        {
            return new Input(false, name);
        }
    },
    PROBE() {
        @Override
        public Node getInstance(String name)
        {
            return new Probe(name);
        }
    },
    AND() {
        @Override
        public Node getInstance(String name)
        {
            return new AndGate(name);
        }
    },
    OR() {
        @Override
        public Node getInstance(String name)
        {
            return new OrGate(name);
        }
    },
    NOT() {
        @Override
        public Node getInstance(String name)
        {
            return new NotGate(name);
        }
    },
    NOR() {
        @Override
        public Node getInstance(String name)
        {
            return new NOrGate(name);
        }
    },
    XOR() {
        @Override
        public Node getInstance(String name)
        {
            return new XOrGate(name);
        }
    },
    NAND() {
        @Override
        public Node getInstance(String name)
        {
            return new NAndGate(name);
        }
    };

    public abstract Node getInstance(String name);
}
