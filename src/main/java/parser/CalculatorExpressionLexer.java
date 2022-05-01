// Generated from /home/thomas/Desktop/calc/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DECIMAL=6, IMAGINARY=7, BOOLEAN=8, 
		PLUS=9, MINUS=10, MULT=11, DIV=12, POW=13, LOGICAL_NOT=14, LOGICAL_OR=15, 
		LOGICAL_AND=16, LOGICAL_XOR=17, LOGICAL_IMPLICATION=18, LOGICAL_EQUIVALENCE=19, 
		FUNCTION_IDENTIFIER=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "INT", "DECIMAL", "IMAGINARY", "BOOLEAN", 
			"PLUS", "MINUS", "MULT", "DIV", "POW", "LOGICAL_NOT", "LOGICAL_OR", "LOGICAL_AND", 
			"LOGICAL_XOR", "LOGICAL_IMPLICATION", "LOGICAL_EQUIVALENCE", "FUNCTION_IDENTIFIER", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':='", "'x'", null, null, null, null, "'+'", "'-'", 
			"'\u00D7'", "'/'", "'^'", "'NOT'", "'OR'", "'AND'", "'XOR'", "'==>'", 
			"'<==>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT", "DECIMAL", "IMAGINARY", "BOOLEAN", 
			"PLUS", "MINUS", "MULT", "DIV", "POW", "LOGICAL_NOT", "LOGICAL_OR", "LOGICAL_AND", 
			"LOGICAL_XOR", "LOGICAL_IMPLICATION", "LOGICAL_EQUIVALENCE", "FUNCTION_IDENTIFIER", 
			"WS"
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


	public CalculatorExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalculatorExpression.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\6\68\n\6\r\6\16\69\3\7\6\7=\n\7\r\7\16\7>\3\7\3\7\6\7"+
		"C\n\7\r\7\16\7D\3\b\7\bH\n\b\f\b\16\bK\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\tX\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\6\25}\n\25\r\25"+
		"\16\25~\3\26\6\26\u0082\n\26\r\26\16\26\u0083\3\26\3\26\2\2\27\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27\3\2\5\3\2\62;\3\2c|\5\2\13\f\17\17\"\"\2\u008d\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2"+
		"\7\61\3\2\2\2\t\64\3\2\2\2\13\67\3\2\2\2\r<\3\2\2\2\17I\3\2\2\2\21W\3"+
		"\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31_\3\2\2\2\33a\3\2\2\2\35"+
		"c\3\2\2\2\37g\3\2\2\2!j\3\2\2\2#n\3\2\2\2%r\3\2\2\2\'v\3\2\2\2)|\3\2\2"+
		"\2+\u0081\3\2\2\2-.\7*\2\2.\4\3\2\2\2/\60\7+\2\2\60\6\3\2\2\2\61\62\7"+
		"<\2\2\62\63\7?\2\2\63\b\3\2\2\2\64\65\7z\2\2\65\n\3\2\2\2\668\t\2\2\2"+
		"\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\f\3\2\2\2;=\t\2\2\2<;"+
		"\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@B\7\60\2\2AC\t\2\2\2"+
		"BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\16\3\2\2\2FH\t\2\2\2GF\3\2\2"+
		"\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7k\2\2M\20\3\2"+
		"\2\2NO\7V\2\2OP\7T\2\2PQ\7W\2\2QX\7G\2\2RS\7H\2\2ST\7C\2\2TU\7N\2\2UV"+
		"\7U\2\2VX\7G\2\2WN\3\2\2\2WR\3\2\2\2X\22\3\2\2\2YZ\7-\2\2Z\24\3\2\2\2"+
		"[\\\7/\2\2\\\26\3\2\2\2]^\7\u00d9\2\2^\30\3\2\2\2_`\7\61\2\2`\32\3\2\2"+
		"\2ab\7`\2\2b\34\3\2\2\2cd\7P\2\2de\7Q\2\2ef\7V\2\2f\36\3\2\2\2gh\7Q\2"+
		"\2hi\7T\2\2i \3\2\2\2jk\7C\2\2kl\7P\2\2lm\7F\2\2m\"\3\2\2\2no\7Z\2\2o"+
		"p\7Q\2\2pq\7T\2\2q$\3\2\2\2rs\7?\2\2st\7?\2\2tu\7@\2\2u&\3\2\2\2vw\7>"+
		"\2\2wx\7?\2\2xy\7?\2\2yz\7@\2\2z(\3\2\2\2{}\t\3\2\2|{\3\2\2\2}~\3\2\2"+
		"\2~|\3\2\2\2~\177\3\2\2\2\177*\3\2\2\2\u0080\u0082\t\4\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\b\26\2\2\u0086,\3\2\2\2\n\29>DIW~\u0083\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}