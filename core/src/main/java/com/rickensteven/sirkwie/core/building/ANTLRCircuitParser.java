package com.rickensteven.sirkwie.core.building;

import com.rickensteven.sirkwie.core.DP1CircuitLexer;
import com.rickensteven.sirkwie.core.DP1CircuitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRCircuitParser implements ICircuitParser
{
    public CircuitDefinition parse(String cleanedTxtCircuit)
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(cleanedTxtCircuit);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);
        DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);

        ParseTree parseTree = dp1CircuitParser.file();

        //TODO Convert parsetree to CircuitDefinition

        return new CircuitDefinition(null, null);
    }
}
