package com.rickensteven.sirkwie.core.domain;

public interface INodeVisitor
{
    void visit(Probe node);
    void visit(Input node);
    void visit(AndGate node);
    void visit(NAndGate node);
    void visit(NOrGate node);
    void visit(NotGate node);
    void visit(OrGate node);
    void visit(XOrGate node);
}
