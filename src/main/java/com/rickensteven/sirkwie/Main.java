package com.rickensteven.sirkwie;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main
{
    public static void main(String[] args)
    {
        try {
            // Read circuit
            CircuitFileReader circuitFileReader = new CircuitFileReader();
            String cleanedTxtCircuit = circuitFileReader.read("Circuit1_FullAdder.txt");

            // Process it with ANTLR
            ANTLRInputStream antlrInputStream = new ANTLRInputStream(cleanedTxtCircuit);
            DP1CircuitLexer dp1CircuitLexer = new DP1CircuitLexer(antlrInputStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(dp1CircuitLexer);
            DP1CircuitParser dp1CircuitParser = new DP1CircuitParser(commonTokenStream);

            ParseTree parseTree = dp1CircuitParser.file();

        } catch (Exception exception) {
            System.err.println("Failed to read circuit");
            exception.printStackTrace();
        }
    }
}
