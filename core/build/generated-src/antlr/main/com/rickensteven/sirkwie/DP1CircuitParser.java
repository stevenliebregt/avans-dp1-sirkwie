// Generated from com/rickensteven/sirkwie/DP1Circuit.g4 by ANTLR 4.5

package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DP1CircuitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NODE_DESCRIPTOR=1, IDENTIFIER=2, GROUP_SEPARATOR=3, ID_DESC_SEPARATOR=4, 
		DESC_SEPARATOR=5, EOL=6, COMMENT=7, NEWLINE=8, WS=9;
	public static final int
		RULE_file = 0, RULE_nodeDefinitions = 1, RULE_edgeDefinitions = 2, RULE_nodeDefinition = 3, 
		RULE_edgeDefinition = 4;
	public static final String[] ruleNames = {
		"file", "nodeDefinitions", "edgeDefinitions", "nodeDefinition", "edgeDefinition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NODE_DESCRIPTOR", "IDENTIFIER", "GROUP_SEPARATOR", "ID_DESC_SEPARATOR", 
		"DESC_SEPARATOR", "EOL", "COMMENT", "NEWLINE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DP1Circuit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DP1CircuitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public NodeDefinitionsContext nodeDefinitions() {
			return getRuleContext(NodeDefinitionsContext.class,0);
		}
		public TerminalNode GROUP_SEPARATOR() { return getToken(DP1CircuitParser.GROUP_SEPARATOR, 0); }
		public EdgeDefinitionsContext edgeDefinitions() {
			return getRuleContext(EdgeDefinitionsContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DP1CircuitVisitor ) return ((DP1CircuitVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			nodeDefinitions();
			setState(11);
			match(GROUP_SEPARATOR);
			setState(12);
			edgeDefinitions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeDefinitionsContext extends ParserRuleContext {
		public List<NodeDefinitionContext> nodeDefinition() {
			return getRuleContexts(NodeDefinitionContext.class);
		}
		public NodeDefinitionContext nodeDefinition(int i) {
			return getRuleContext(NodeDefinitionContext.class,i);
		}
		public NodeDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).enterNodeDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).exitNodeDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DP1CircuitVisitor ) return ((DP1CircuitVisitor<? extends T>)visitor).visitNodeDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeDefinitionsContext nodeDefinitions() throws RecognitionException {
		NodeDefinitionsContext _localctx = new NodeDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nodeDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				nodeDefinition();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeDefinitionsContext extends ParserRuleContext {
		public List<EdgeDefinitionContext> edgeDefinition() {
			return getRuleContexts(EdgeDefinitionContext.class);
		}
		public EdgeDefinitionContext edgeDefinition(int i) {
			return getRuleContext(EdgeDefinitionContext.class,i);
		}
		public EdgeDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).enterEdgeDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).exitEdgeDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DP1CircuitVisitor ) return ((DP1CircuitVisitor<? extends T>)visitor).visitEdgeDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeDefinitionsContext edgeDefinitions() throws RecognitionException {
		EdgeDefinitionsContext _localctx = new EdgeDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edgeDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				edgeDefinition();
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeDefinitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DP1CircuitParser.IDENTIFIER, 0); }
		public TerminalNode ID_DESC_SEPARATOR() { return getToken(DP1CircuitParser.ID_DESC_SEPARATOR, 0); }
		public TerminalNode NODE_DESCRIPTOR() { return getToken(DP1CircuitParser.NODE_DESCRIPTOR, 0); }
		public TerminalNode EOL() { return getToken(DP1CircuitParser.EOL, 0); }
		public NodeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).enterNodeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).exitNodeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DP1CircuitVisitor ) return ((DP1CircuitVisitor<? extends T>)visitor).visitNodeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeDefinitionContext nodeDefinition() throws RecognitionException {
		NodeDefinitionContext _localctx = new NodeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nodeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(IDENTIFIER);
			setState(25);
			match(ID_DESC_SEPARATOR);
			setState(26);
			match(NODE_DESCRIPTOR);
			setState(27);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(DP1CircuitParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DP1CircuitParser.IDENTIFIER, i);
		}
		public TerminalNode ID_DESC_SEPARATOR() { return getToken(DP1CircuitParser.ID_DESC_SEPARATOR, 0); }
		public TerminalNode EOL() { return getToken(DP1CircuitParser.EOL, 0); }
		public List<TerminalNode> DESC_SEPARATOR() { return getTokens(DP1CircuitParser.DESC_SEPARATOR); }
		public TerminalNode DESC_SEPARATOR(int i) {
			return getToken(DP1CircuitParser.DESC_SEPARATOR, i);
		}
		public EdgeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).enterEdgeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DP1CircuitListener ) ((DP1CircuitListener)listener).exitEdgeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DP1CircuitVisitor ) return ((DP1CircuitVisitor<? extends T>)visitor).visitEdgeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeDefinitionContext edgeDefinition() throws RecognitionException {
		EdgeDefinitionContext _localctx = new EdgeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_edgeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(IDENTIFIER);
			setState(30);
			match(ID_DESC_SEPARATOR);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(31);
					match(IDENTIFIER);
					}
					break;
				case DESC_SEPARATOR:
					{
					setState(32);
					match(DESC_SEPARATOR);
					setState(33);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER || _la==DESC_SEPARATOR );
			setState(38);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13+\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\3\6\3\22\n\3\r\3\16\3\23"+
		"\3\4\6\4\27\n\4\r\4\16\4\30\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6"+
		"\6%\n\6\r\6\16\6&\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2)\2\f\3\2\2\2\4\21\3"+
		"\2\2\2\6\26\3\2\2\2\b\32\3\2\2\2\n\37\3\2\2\2\f\r\5\4\3\2\r\16\7\5\2\2"+
		"\16\17\5\6\4\2\17\3\3\2\2\2\20\22\5\b\5\2\21\20\3\2\2\2\22\23\3\2\2\2"+
		"\23\21\3\2\2\2\23\24\3\2\2\2\24\5\3\2\2\2\25\27\5\n\6\2\26\25\3\2\2\2"+
		"\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\7\3\2\2\2\32\33\7\4\2\2"+
		"\33\34\7\6\2\2\34\35\7\3\2\2\35\36\7\b\2\2\36\t\3\2\2\2\37 \7\4\2\2 $"+
		"\7\6\2\2!%\7\4\2\2\"#\7\7\2\2#%\7\4\2\2$!\3\2\2\2$\"\3\2\2\2%&\3\2\2\2"+
		"&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\b\2\2)\13\3\2\2\2\6\23\30$&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}