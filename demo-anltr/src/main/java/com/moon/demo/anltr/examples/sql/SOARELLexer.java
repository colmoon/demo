// Generated from D:/Code/IdeaProjects/demo/src/main/java/com/anhen/anltr/examples/sql\SOAREL.g4 by ANTLR 4.8
package com.moon.demo.anltr.examples.sql;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SOARELLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AND=7, OR=8, EQ=9, NE=10, 
		LT=11, GT=12, LE=13, GE=14, DIV=15, ADD=16, IN=17, NOTIN=18, LIKE=19, 
		IDENTIFIER=20, STRING=21, NUMBER=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "AND", "OR", "EQ", "NE", 
			"LT", "GT", "LE", "GE", "DIV", "ADD", "IN", "NOTIN", "LIKE", "IDENTIFIER", 
			"STRING", "ESC", "UNICODE", "HEX", "NUMBER", "INT", "EXP", "WS", "A", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'true'", "'false'", "'null'", null, null, 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'/'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "AND", "OR", "EQ", "NE", "LT", 
			"GT", "LE", "GE", "DIV", "ADD", "IN", "NOTIN", "LIKE", "IDENTIFIER", 
			"STRING", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public SOARELLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SOAREL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u013a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u00b1\n\25\f\25\16"+
		"\25\u00b4\13\25\3\25\6\25\u00b7\n\25\r\25\16\25\u00b8\3\25\3\25\7\25\u00bd"+
		"\n\25\f\25\16\25\u00c0\13\25\5\25\u00c2\n\25\3\26\3\26\3\26\7\26\u00c7"+
		"\n\26\f\26\16\26\u00ca\13\26\3\26\3\26\3\27\3\27\3\27\5\27\u00d1\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\5\32\u00dc\n\32\3\32\3\32"+
		"\3\32\3\32\5\32\u00e2\n\32\3\32\5\32\u00e5\n\32\3\32\3\32\3\32\3\32\5"+
		"\32\u00eb\n\32\3\32\5\32\u00ee\n\32\3\33\3\33\3\33\7\33\u00f3\n\33\f\33"+
		"\16\33\u00f6\13\33\5\33\u00f8\n\33\3\34\3\34\5\34\u00fc\n\34\3\34\3\34"+
		"\3\35\6\35\u0101\n\35\r\35\16\35\u0102\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\2\28\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\2/\2\61\2\63\30\65\2\67\29\31;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2"+
		"S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2\3\2$\5\2C\\aac|\6\2\62;C\\"+
		"aac|\3\2\62;\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\4\2GGgg\4\2-"+
		"-//\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2HHhh\4\2IIi"+
		"i\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2OOpp\4\2QQqq\4\2"+
		"RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4"+
		"\2[[{{\4\2\\\\||\2\u012b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2\63\3\2\2\2\29\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2"+
		"\13z\3\2\2\2\r\u0080\3\2\2\2\17\u0085\3\2\2\2\21\u0089\3\2\2\2\23\u008c"+
		"\3\2\2\2\25\u008f\3\2\2\2\27\u0092\3\2\2\2\31\u0094\3\2\2\2\33\u0096\3"+
		"\2\2\2\35\u0099\3\2\2\2\37\u009c\3\2\2\2!\u009e\3\2\2\2#\u00a0\3\2\2\2"+
		"%\u00a3\3\2\2\2\'\u00a9\3\2\2\2)\u00c1\3\2\2\2+\u00c3\3\2\2\2-\u00cd\3"+
		"\2\2\2/\u00d2\3\2\2\2\61\u00d8\3\2\2\2\63\u00ed\3\2\2\2\65\u00f7\3\2\2"+
		"\2\67\u00f9\3\2\2\29\u0100\3\2\2\2;\u0106\3\2\2\2=\u0108\3\2\2\2?\u010a"+
		"\3\2\2\2A\u010c\3\2\2\2C\u010e\3\2\2\2E\u0110\3\2\2\2G\u0112\3\2\2\2I"+
		"\u0114\3\2\2\2K\u0116\3\2\2\2M\u0118\3\2\2\2O\u011a\3\2\2\2Q\u011c\3\2"+
		"\2\2S\u011e\3\2\2\2U\u0120\3\2\2\2W\u0122\3\2\2\2Y\u0124\3\2\2\2[\u0126"+
		"\3\2\2\2]\u0128\3\2\2\2_\u012a\3\2\2\2a\u012c\3\2\2\2c\u012e\3\2\2\2e"+
		"\u0130\3\2\2\2g\u0132\3\2\2\2i\u0134\3\2\2\2k\u0136\3\2\2\2m\u0138\3\2"+
		"\2\2op\7]\2\2p\4\3\2\2\2qr\7.\2\2r\6\3\2\2\2st\7_\2\2t\b\3\2\2\2uv\7v"+
		"\2\2vw\7t\2\2wx\7w\2\2xy\7g\2\2y\n\3\2\2\2z{\7h\2\2{|\7c\2\2|}\7n\2\2"+
		"}~\7u\2\2~\177\7g\2\2\177\f\3\2\2\2\u0080\u0081\7p\2\2\u0081\u0082\7w"+
		"\2\2\u0082\u0083\7n\2\2\u0083\u0084\7n\2\2\u0084\16\3\2\2\2\u0085\u0086"+
		"\5;\36\2\u0086\u0087\5U+\2\u0087\u0088\5A!\2\u0088\20\3\2\2\2\u0089\u008a"+
		"\5W,\2\u008a\u008b\5]/\2\u008b\22\3\2\2\2\u008c\u008d\7?\2\2\u008d\u008e"+
		"\7?\2\2\u008e\24\3\2\2\2\u008f\u0090\7#\2\2\u0090\u0091\7?\2\2\u0091\26"+
		"\3\2\2\2\u0092\u0093\7>\2\2\u0093\30\3\2\2\2\u0094\u0095\7@\2\2\u0095"+
		"\32\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098\34\3\2\2\2\u0099"+
		"\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b\36\3\2\2\2\u009c\u009d\7\61\2\2"+
		"\u009d \3\2\2\2\u009e\u009f\7-\2\2\u009f\"\3\2\2\2\u00a0\u00a1\5K&\2\u00a1"+
		"\u00a2\5U+\2\u00a2$\3\2\2\2\u00a3\u00a4\5U+\2\u00a4\u00a5\5W,\2\u00a5"+
		"\u00a6\5a\61\2\u00a6\u00a7\5K&\2\u00a7\u00a8\5U+\2\u00a8&\3\2\2\2\u00a9"+
		"\u00aa\5Q)\2\u00aa\u00ab\5K&\2\u00ab\u00ac\5O(\2\u00ac\u00ad\5C\"\2\u00ad"+
		"(\3\2\2\2\u00ae\u00b2\t\2\2\2\u00af\u00b1\t\3\2\2\u00b0\u00af\3\2\2\2"+
		"\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00c2"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\t\4\2\2\u00b6\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00be\t\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c1\u00ae\3\2\2\2\u00c1\u00b6\3\2\2\2\u00c2"+
		"*\3\2\2\2\u00c3\u00c8\7$\2\2\u00c4\u00c7\5-\27\2\u00c5\u00c7\n\5\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cc\7$\2\2\u00cc,\3\2\2\2\u00cd\u00d0\7^\2\2\u00ce\u00d1\t\6\2\2\u00cf"+
		"\u00d1\5/\30\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1.\3\2\2\2"+
		"\u00d2\u00d3\7w\2\2\u00d3\u00d4\5\61\31\2\u00d4\u00d5\5\61\31\2\u00d5"+
		"\u00d6\5\61\31\2\u00d6\u00d7\5\61\31\2\u00d7\60\3\2\2\2\u00d8\u00d9\t"+
		"\7\2\2\u00d9\62\3\2\2\2\u00da\u00dc\7/\2\2\u00db\u00da\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\5\65\33\2\u00de\u00df\7\60\2"+
		"\2\u00df\u00e1\5\65\33\2\u00e0\u00e2\5\67\34\2\u00e1\u00e0\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00ee\3\2\2\2\u00e3\u00e5\7/\2\2\u00e4\u00e3\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\5\65\33\2\u00e7"+
		"\u00e8\5\67\34\2\u00e8\u00ee\3\2\2\2\u00e9\u00eb\7/\2\2\u00ea\u00e9\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\5\65\33\2\u00ed"+
		"\u00db\3\2\2\2\u00ed\u00e4\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ee\64\3\2\2"+
		"\2\u00ef\u00f8\7\62\2\2\u00f0\u00f4\4\63;\2\u00f1\u00f3\4\62;\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7"+
		"\u00f0\3\2\2\2\u00f8\66\3\2\2\2\u00f9\u00fb\t\b\2\2\u00fa\u00fc\t\t\2"+
		"\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe"+
		"\5\65\33\2\u00fe8\3\2\2\2\u00ff\u0101\t\n\2\2\u0100\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0105\b\35\2\2\u0105:\3\2\2\2\u0106\u0107\t\13\2\2\u0107<\3"+
		"\2\2\2\u0108\u0109\t\f\2\2\u0109>\3\2\2\2\u010a\u010b\t\r\2\2\u010b@\3"+
		"\2\2\2\u010c\u010d\t\16\2\2\u010dB\3\2\2\2\u010e\u010f\t\b\2\2\u010fD"+
		"\3\2\2\2\u0110\u0111\t\17\2\2\u0111F\3\2\2\2\u0112\u0113\t\20\2\2\u0113"+
		"H\3\2\2\2\u0114\u0115\t\21\2\2\u0115J\3\2\2\2\u0116\u0117\t\22\2\2\u0117"+
		"L\3\2\2\2\u0118\u0119\t\23\2\2\u0119N\3\2\2\2\u011a\u011b\t\24\2\2\u011b"+
		"P\3\2\2\2\u011c\u011d\t\25\2\2\u011dR\3\2\2\2\u011e\u011f\t\26\2\2\u011f"+
		"T\3\2\2\2\u0120\u0121\t\27\2\2\u0121V\3\2\2\2\u0122\u0123\t\30\2\2\u0123"+
		"X\3\2\2\2\u0124\u0125\t\31\2\2\u0125Z\3\2\2\2\u0126\u0127\t\32\2\2\u0127"+
		"\\\3\2\2\2\u0128\u0129\t\33\2\2\u0129^\3\2\2\2\u012a\u012b\t\34\2\2\u012b"+
		"`\3\2\2\2\u012c\u012d\t\35\2\2\u012db\3\2\2\2\u012e\u012f\t\36\2\2\u012f"+
		"d\3\2\2\2\u0130\u0131\t\37\2\2\u0131f\3\2\2\2\u0132\u0133\t \2\2\u0133"+
		"h\3\2\2\2\u0134\u0135\t!\2\2\u0135j\3\2\2\2\u0136\u0137\t\"\2\2\u0137"+
		"l\3\2\2\2\u0138\u0139\t#\2\2\u0139n\3\2\2\2\23\2\u00b2\u00b8\u00be\u00c1"+
		"\u00c6\u00c8\u00d0\u00db\u00e1\u00e4\u00ea\u00ed\u00f4\u00f7\u00fb\u0102"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}