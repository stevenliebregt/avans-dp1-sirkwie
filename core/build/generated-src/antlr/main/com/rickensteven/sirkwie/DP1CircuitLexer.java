// Generated from com/rickensteven/sirkwie/DP1Circuit.g4 by ANTLR 4.5

package com.rickensteven.sirkwie.core;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DP1CircuitLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NODE_DESCRIPTOR=1, IDENTIFIER=2, GROUP_SEPARATOR=3, ID_DESC_SEPARATOR=4, 
		DESC_SEPARATOR=5, EOL=6, COMMENT=7, NEWLINE=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NODE_DESCRIPTOR", "IDENTIFIER", "GROUP_SEPARATOR", "ID_DESC_SEPARATOR", 
		"DESC_SEPARATOR", "EOL", "COMMENT", "NEWLINE", "WS"
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


	public DP1CircuitLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DP1Circuit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2@\n\2\3\3\6\3C\n\3\r\3\16\3D\3\3\7\3H\n\3\f\3"+
		"\16\3K\13\3\3\4\6\4N\n\4\r\4\16\4O\3\5\3\5\3\6\3\6\3\7\3\7\7\7X\n\7\f"+
		"\7\16\7[\13\7\3\7\3\7\5\7_\n\7\3\b\3\b\7\bc\n\b\f\b\16\bf\13\b\3\b\6\b"+
		"i\n\b\r\b\16\bj\3\b\3\b\3\t\3\t\3\t\5\tr\n\t\3\n\6\nu\n\n\r\n\16\nv\3"+
		"\n\3\n\4Yd\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\4\2C\\"+
		"c|\5\2\62;C\\c|\4\2\f\f\17\17\4\2\13\13\"\"\u008a\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\3?\3\2\2\2\5B\3\2\2\2\7M\3\2\2\2\tQ\3\2\2\2\13S"+
		"\3\2\2\2\rU\3\2\2\2\17`\3\2\2\2\21q\3\2\2\2\23t\3\2\2\2\25\26\7K\2\2\26"+
		"\27\7P\2\2\27\30\7R\2\2\30\31\7W\2\2\31\32\7V\2\2\32\33\7a\2\2\33\34\7"+
		"J\2\2\34\35\7K\2\2\35\36\7I\2\2\36@\7J\2\2\37 \7K\2\2 !\7P\2\2!\"\7R\2"+
		"\2\"#\7W\2\2#$\7V\2\2$%\7a\2\2%&\7N\2\2&\'\7Q\2\2\'@\7Y\2\2()\7R\2\2)"+
		"*\7T\2\2*+\7Q\2\2+,\7D\2\2,@\7G\2\2-.\7C\2\2./\7P\2\2/@\7F\2\2\60\61\7"+
		"P\2\2\61\62\7C\2\2\62\63\7P\2\2\63@\7F\2\2\64\65\7Q\2\2\65@\7T\2\2\66"+
		"\67\7P\2\2\678\7Q\2\28@\7T\2\29:\7Z\2\2:;\7Q\2\2;@\7T\2\2<=\7P\2\2=>\7"+
		"Q\2\2>@\7V\2\2?\25\3\2\2\2?\37\3\2\2\2?(\3\2\2\2?-\3\2\2\2?\60\3\2\2\2"+
		"?\64\3\2\2\2?\66\3\2\2\2?9\3\2\2\2?<\3\2\2\2@\4\3\2\2\2AC\t\2\2\2BA\3"+
		"\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EI\3\2\2\2FH\t\3\2\2GF\3\2\2\2HK\3"+
		"\2\2\2IG\3\2\2\2IJ\3\2\2\2J\6\3\2\2\2KI\3\2\2\2LN\5\21\t\2ML\3\2\2\2N"+
		"O\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\b\3\2\2\2QR\7<\2\2R\n\3\2\2\2ST\7.\2\2"+
		"T\f\3\2\2\2UY\7=\2\2VX\13\2\2\2WV\3\2\2\2X[\3\2\2\2YZ\3\2\2\2YW\3\2\2"+
		"\2Z^\3\2\2\2[Y\3\2\2\2\\_\5\21\t\2]_\7\2\2\3^\\\3\2\2\2^]\3\2\2\2_\16"+
		"\3\2\2\2`d\7%\2\2ac\13\2\2\2ba\3\2\2\2cf\3\2\2\2de\3\2\2\2db\3\2\2\2e"+
		"h\3\2\2\2fd\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"kl\3\2\2\2lm\b\b\2\2m\20\3\2\2\2no\7\17\2\2or\7\f\2\2pr\t\4\2\2qn\3\2"+
		"\2\2qp\3\2\2\2r\22\3\2\2\2su\t\5\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2wx\3\2\2\2xy\b\n\2\2y\24\3\2\2\2\r\2?DIOY^djqv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}