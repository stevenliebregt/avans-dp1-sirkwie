package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.util.LexerUtil;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DP1CircuitLexerTest
{
    @Test
    public void parseNodeDefinition()
    {
        List<Token> tokens = LexerUtil.getTokens("A: INPUT_HIGH;");

        assertEquals(5, tokens.size());
        assertEquals(com.rickensteven.sirkwie.core.DP1CircuitLexer.IDENTIFIER, tokens.get(0).getType());
        assertEquals(com.rickensteven.sirkwie.core.DP1CircuitLexer.ID_DESC_SEPARATOR, tokens.get(1).getType());
        assertEquals(com.rickensteven.sirkwie.core.DP1CircuitLexer.NODE_DESCRIPTOR, tokens.get(2).getType());
        assertEquals(com.rickensteven.sirkwie.core.DP1CircuitLexer.EOL, tokens.get(3).getType());
        assertEquals(com.rickensteven.sirkwie.core.DP1CircuitLexer.EOF, tokens.get(4).getType());
    }

    // TODO: Make the rest of the tests if we are allowed to use ANTLR
}
