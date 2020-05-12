// Generated from com/rickensteven/sirkwie/DP1Circuit.g4 by ANTLR 4.5

package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DP1CircuitParser}.
 */
public interface DP1CircuitListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DP1CircuitParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(DP1CircuitParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link DP1CircuitParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(DP1CircuitParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link DP1CircuitParser#nodeDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterNodeDefinitions(DP1CircuitParser.NodeDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DP1CircuitParser#nodeDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitNodeDefinitions(DP1CircuitParser.NodeDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DP1CircuitParser#edgeDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterEdgeDefinitions(DP1CircuitParser.EdgeDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DP1CircuitParser#edgeDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitEdgeDefinitions(DP1CircuitParser.EdgeDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DP1CircuitParser#nodeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNodeDefinition(DP1CircuitParser.NodeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DP1CircuitParser#nodeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNodeDefinition(DP1CircuitParser.NodeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DP1CircuitParser#edgeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEdgeDefinition(DP1CircuitParser.EdgeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DP1CircuitParser#edgeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEdgeDefinition(DP1CircuitParser.EdgeDefinitionContext ctx);
}