package com.rickensteven.sirkwie.core.parsing;

import com.rickensteven.sirkwie.core.antlr.DP1CircuitLexer;
import com.rickensteven.sirkwie.core.antlr.DP1CircuitParser;
import com.rickensteven.sirkwie.core.building.CircuitDefinition;
import com.rickensteven.sirkwie.core.exception.CircuitSyntaxException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRCircuitParser implements ICircuitParser
{
    public CircuitDefinition parse(String cleanedTxtCircuit) throws CircuitSyntaxException
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(cleanedTxtCircuit);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);

        ANTLRParserErrorListener antlrParserErrorListener = new ANTLRParserErrorListener();
        DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);
        dp1CircuitParser.addErrorListener(antlrParserErrorListener);

        ParseTree parseTree = dp1CircuitParser.file();

        // By default ANTLR does not throw an exception when there are syntax
        // errors, since we do want that we check a custom error listener.
        if (antlrParserErrorListener.hasSyntaxErrors()) {
            throw new CircuitSyntaxException("Syntax error in circuit file");
        }

        return convertParseTreeToCircuitDefinition(parseTree);
    }

    private CircuitDefinition convertParseTreeToCircuitDefinition(ParseTree parseTree)
    {
        ANTLRVisitor antlrVisitor = new ANTLRVisitor();

        return antlrVisitor.visit(parseTree);
    }
}
