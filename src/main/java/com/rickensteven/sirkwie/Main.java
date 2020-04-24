package com.rickensteven.sirkwie;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
import java.util.*;

public class Main
{
    // TODO: Remove, JSON tree was found here: https://stackoverflow.com/a/49117903/7448017
    private static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Gson GSON = new Gson();

    public static String toJson(ParseTree tree, boolean prettyPrint)
    {
        return prettyPrint ? PRETTY_PRINT_GSON.toJson(toMap(tree)) : GSON.toJson(toMap(tree));
    }

    public static Map<String, Object> toMap(ParseTree tree)
    {
        Map<String, Object> map = new LinkedHashMap<>();
        traverse(tree, map);
        return map;
    }

    public static void traverse(ParseTree tree, Map<String, Object> map)
    {

        if (tree instanceof TerminalNodeImpl) {
            Token token = ((TerminalNodeImpl) tree).getSymbol();
            map.put("type", token.getType());
            map.put("text", token.getText());
        }
        else {
            List<Map<String, Object>> children = new ArrayList<>();
            String name = tree.getClass().getSimpleName().replaceAll("Context$", "");
            map.put(Character.toLowerCase(name.charAt(0)) + name.substring(1), children);

            for (int i = 0; i < tree.getChildCount(); i++) {
                Map<String, Object> nested = new LinkedHashMap<>();
                children.add(nested);
                traverse(tree.getChild(i), nested);
            }
        }
    }

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

            // TODO: Remove, example to view graphical
            TreeViewer treeViewer = new TreeViewer(Arrays.asList(dp1CircuitParser.getRuleNames()), parseTree);
            treeViewer.open();

            // TODO: Remove, example to view JSON
            System.out.println(toJson(parseTree, true));

            // TODO: Remove, example to view as Lisp
            System.out.println(parseTree.toStringTree(dp1CircuitParser));
        } catch (Exception exception) {
            System.err.println("Failed to read circuit");
            exception.printStackTrace();
        }
    }
}
