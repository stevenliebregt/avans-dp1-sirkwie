package com.rickensteven.sirkwie.core;

import com.rickensteven.sirkwie.core.util.LexerUtil;
import com.rickensteven.sirkwie.core.util.TestANTLRErrorListener;
import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ANTLRCircuitParserTest
{
    @Test
    public void correctStringShouldNotThrowException()
    {
        assertDoesNotThrow(() -> {
            String input = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("Circuit1_FullAdder_Clean.txt")))
                    .lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            CommonTokenStream commonTokenStream = LexerUtil.getTokenStream(input);
            TestANTLRErrorListener testANTLRErrorListener = new TestANTLRErrorListener();

            DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);
            dp1CircuitParser.addErrorListener(testANTLRErrorListener);
            dp1CircuitParser.file();

            assertEquals(0, testANTLRErrorListener.getSyntaxErrorsCount());
            assertFalse(testANTLRErrorListener.hasSyntaxErrors());
        });
    }

    @Test
    public void invalidStringShouldGiveError()
    {
        CommonTokenStream commonTokenStream = LexerUtil.getTokenStream("This is definitely not a valid circuit file");
        TestANTLRErrorListener testANTLRErrorListener = new TestANTLRErrorListener();

        DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);
        dp1CircuitParser.addErrorListener(testANTLRErrorListener);
        dp1CircuitParser.file();

        assertEquals(8, testANTLRErrorListener.getSyntaxErrorsCount());
        assertTrue(testANTLRErrorListener.hasSyntaxErrors());
    }
}
