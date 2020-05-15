package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CircuitParser
{
    public ParseTree parse(String cleanedTxtCircuit)
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(cleanedTxtCircuit);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);
        DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);

        return dp1CircuitParser.file();
    }
}
