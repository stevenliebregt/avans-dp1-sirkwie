// Generated from com/rickensteven/sirkwie/DP1Circuit.g4 by ANTLR 4.5

package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DP1CircuitParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DP1CircuitVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DP1CircuitParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(DP1CircuitParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link DP1CircuitParser#nodeDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeDefinitions(DP1CircuitParser.NodeDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DP1CircuitParser#edgeDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeDefinitions(DP1CircuitParser.EdgeDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DP1CircuitParser#nodeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeDefinition(DP1CircuitParser.NodeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DP1CircuitParser#edgeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeDefinition(DP1CircuitParser.EdgeDefinitionContext ctx);
}