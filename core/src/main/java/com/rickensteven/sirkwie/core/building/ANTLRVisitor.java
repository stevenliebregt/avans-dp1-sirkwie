package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.antlr.DP1CircuitBaseVisitor;
import com.rickensteven.sirkwie.core.antlr.DP1CircuitParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ANTLRVisitor extends DP1CircuitBaseVisitor<CircuitDefinition>
{
    private final HashMap<String, String> nodes;
    private final HashMap<String, List<String>> edges;
    private final CircuitDefinition circuitDefinition;

    public ANTLRVisitor()
    {
        nodes = new LinkedHashMap<>();
        edges = new LinkedHashMap<>();
        circuitDefinition = new CircuitDefinition(nodes, edges);
    }

    @Override
    public CircuitDefinition visit(ParseTree tree)
    {
        super.visit(tree);

        return circuitDefinition;
    }

    @Override
    public CircuitDefinition visitNodeDefinition(DP1CircuitParser.NodeDefinitionContext ctx)
    {
        String identifier = ctx.IDENTIFIER().toString();
        String descriptor = ctx.NODE_DESCRIPTOR().toString();

        nodes.put(identifier, descriptor);

        return super.visitNodeDefinition(ctx);
    }

    @Override
    public CircuitDefinition visitEdgeDefinition(DP1CircuitParser.EdgeDefinitionContext ctx)
    {
        List<TerminalNode> terminalNodes = ctx.IDENTIFIER();

        String identifier = terminalNodes.get(0).toString();
        List<String> edges = new ArrayList<>();

        for (int i = 1; i < terminalNodes.size(); i++) {
            edges.add(terminalNodes.get(i).toString());
        }

        this.edges.put(identifier, edges);

        return super.visitEdgeDefinition(ctx);
    }
}
