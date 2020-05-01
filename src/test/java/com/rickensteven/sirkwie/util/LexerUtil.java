package com.rickensteven.sirkwie.util;

import com.rickensteven.sirkwie.DP1CircuitLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class LexerUtil
{
    public static List<Token> getTokens(String input)
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(input);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);
        commonTokenStream.fill();

        return commonTokenStream.getTokens();
    }
}
