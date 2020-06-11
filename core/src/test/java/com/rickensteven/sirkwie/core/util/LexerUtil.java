package com.rickensteven.sirkwie.core.util;

import com.rickensteven.sirkwie.core.antlr.DP1CircuitLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class LexerUtil
{
    public static CommonTokenStream getTokenStream(String input)
    {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(input);
        DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
        return new CommonTokenStream(dp1CircuitLexer);
    }

    public static List<Token> getTokens(String input)
    {
        CommonTokenStream commonTokenStream = getTokenStream(input);
        commonTokenStream.fill();

        return commonTokenStream.getTokens();
    }
}
