package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.DP1CircuitLexer;
import com.rickensteven.sirkwie.core.DP1CircuitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRCircuitBuilder extends CircuitBuilder
{
    private ParseTree parseTree;

    @Override
    public void reset(String cleanedTxtCircuit)
    {
        super.reset(cleanedTxtCircuit);
        parseTxtToParseTree(cleanedTxtCircuit);
    }

    @Override
    public void buildNodes()
    {
        // TODO:
    }

    @Override
    public void buildEdges()
    {
        // TODO:
    }

    private void parseTxtToParseTree(String cleanedTxtCircuit)
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(cleanedTxtCircuit);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);
        DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);

        parseTree = dp1CircuitParser.file();
    }
}
