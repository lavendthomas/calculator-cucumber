// Generated from /home/thomas/Desktop/calc/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DECIMAL=6, IMAGINARY=7, BOOLEAN=8, 
		PLUS=9, MINUS=10, MULT=11, DIV=12, POW=13, LOGICAL_NOT=14, LOGICAL_OR=15, 
		LOGICAL_AND=16, LOGICAL_XOR=17, LOGICAL_IMPLICATION=18, LOGICAL_EQUIVALENCE=19, 
		FUNCTION_IDENTIFIER=20, WS=21;
	public static final int
		RULE_expression = 0, RULE_parenthesed_expression = 1, RULE_function_call = 2, 
		RULE_equivalence = 3, RULE_implication = 4, RULE_disjunction = 5, RULE_conjunction = 6, 
		RULE_negation = 7, RULE_term = 8, RULE_factor = 9, RULE_pow = 10, RULE_value = 11, 
		RULE_number = 12, RULE_function_defintion = 13, RULE_function_function_call = 14, 
		RULE_function_parenthesed_expression = 15, RULE_function_term = 16, RULE_function_factor = 17, 
		RULE_function_pow = 18, RULE_function_value = 19, RULE_variable = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "parenthesed_expression", "function_call", "equivalence", 
			"implication", "disjunction", "conjunction", "negation", "term", "factor", 
			"pow", "value", "number", "function_defintion", "function_function_call", 
			"function_parenthesed_expression", "function_term", "function_factor", 
			"function_pow", "function_value", "variable"
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

	@Override
	public String getGrammarFileName() { return "CalculatorExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public EquivalenceContext equivalence() {
			return getRuleContext(EquivalenceContext.class,0);
		}
		public Function_defintionContext function_defintion() {
			return getRuleContext(Function_defintionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				equivalence(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				function_defintion();
				}
				break;
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

	public static class Parenthesed_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Parenthesed_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesed_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterParenthesed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitParenthesed_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitParenthesed_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parenthesed_expressionContext parenthesed_expression() throws RecognitionException {
		Parenthesed_expressionContext _localctx = new Parenthesed_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parenthesed_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			expression();
			setState(48);
			match(T__1);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(FUNCTION_IDENTIFIER);
			setState(51);
			match(T__0);
			setState(52);
			term(0);
			setState(53);
			match(T__1);
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

	public static class EquivalenceContext extends ParserRuleContext {
		public ImplicationContext implication() {
			return getRuleContext(ImplicationContext.class,0);
		}
		public EquivalenceContext equivalence() {
			return getRuleContext(EquivalenceContext.class,0);
		}
		public TerminalNode LOGICAL_EQUIVALENCE() { return getToken(CalculatorExpressionParser.LOGICAL_EQUIVALENCE, 0); }
		public EquivalenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equivalence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterEquivalence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitEquivalence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitEquivalence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquivalenceContext equivalence() throws RecognitionException {
		return equivalence(0);
	}

	private EquivalenceContext equivalence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EquivalenceContext _localctx = new EquivalenceContext(_ctx, _parentState);
		EquivalenceContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_equivalence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(56);
			implication(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EquivalenceContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equivalence);
					setState(58);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(59);
					match(LOGICAL_EQUIVALENCE);
					setState(60);
					implication(0);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ImplicationContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public ImplicationContext implication() {
			return getRuleContext(ImplicationContext.class,0);
		}
		public TerminalNode LOGICAL_IMPLICATION() { return getToken(CalculatorExpressionParser.LOGICAL_IMPLICATION, 0); }
		public ImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterImplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitImplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicationContext implication() throws RecognitionException {
		return implication(0);
	}

	private ImplicationContext implication(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ImplicationContext _localctx = new ImplicationContext(_ctx, _parentState);
		ImplicationContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_implication, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			disjunction(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ImplicationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_implication);
					setState(69);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(70);
					match(LOGICAL_IMPLICATION);
					setState(71);
					disjunction(0);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DisjunctionContext extends ParserRuleContext {
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public TerminalNode LOGICAL_OR() { return getToken(CalculatorExpressionParser.LOGICAL_OR, 0); }
		public TerminalNode LOGICAL_XOR() { return getToken(CalculatorExpressionParser.LOGICAL_XOR, 0); }
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		return disjunction(0);
	}

	private DisjunctionContext disjunction(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, _parentState);
		DisjunctionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_disjunction, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(78);
			conjunction(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new DisjunctionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_disjunction);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						match(LOGICAL_OR);
						setState(82);
						conjunction(0);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_disjunction);
						setState(83);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(84);
						match(LOGICAL_XOR);
						setState(85);
						conjunction(0);
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public TerminalNode LOGICAL_AND() { return getToken(CalculatorExpressionParser.LOGICAL_AND, 0); }
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		return conjunction(0);
	}

	private ConjunctionContext conjunction(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, _parentState);
		ConjunctionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_conjunction, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(92);
			negation();
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConjunctionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conjunction);
					setState(94);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(95);
					match(LOGICAL_AND);
					setState(96);
					negation();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NegationContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode LOGICAL_NOT() { return getToken(CalculatorExpressionParser.LOGICAL_NOT, 0); }
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_negation);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case BOOLEAN:
			case MINUS:
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				term(0);
				}
				break;
			case LOGICAL_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(LOGICAL_NOT);
				setState(104);
				term(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(110);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(111);
						match(PLUS);
						setState(112);
						factor(0);
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(113);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(114);
						match(MINUS);
						setState(115);
						factor(0);
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CalculatorExpressionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorExpressionParser.DIV, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(122);
			pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(130);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(124);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(125);
						match(MULT);
						setState(126);
						pow(0);
						}
						break;
					case 2:
						{
						_localctx = new FactorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(127);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(128);
						match(DIV);
						setState(129);
						pow(0);
						}
						break;
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PowContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorExpressionParser.POW, 0); }
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		return pow(0);
	}

	private PowContext pow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PowContext _localctx = new PowContext(_ctx, _parentState);
		PowContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(136);
			value();
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pow);
					setState(138);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(139);
					match(POW);
					setState(140);
					value();
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(CalculatorExpressionParser.BOOLEAN, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Parenthesed_expressionContext parenthesed_expression() {
			return getRuleContext(Parenthesed_expressionContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				number();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(BOOLEAN);
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				parenthesed_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CalculatorExpressionParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CalculatorExpressionParser.DECIMAL, 0); }
		public TerminalNode IMAGINARY() { return getToken(CalculatorExpressionParser.IMAGINARY, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(152);
				match(MINUS);
				}
			}

			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DECIMAL) | (1L << IMAGINARY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Function_defintionContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_defintionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_defintion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_defintion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_defintion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_defintion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defintionContext function_defintion() throws RecognitionException {
		Function_defintionContext _localctx = new Function_defintionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_defintion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(FUNCTION_IDENTIFIER);
			setState(158);
			match(T__2);
			setState(159);
			function_term(0);
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

	public static class Function_function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION_IDENTIFIER() { return getToken(CalculatorExpressionParser.FUNCTION_IDENTIFIER, 0); }
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_function_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_function_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_function_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_function_callContext function_function_call() throws RecognitionException {
		Function_function_callContext _localctx = new Function_function_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(FUNCTION_IDENTIFIER);
			setState(162);
			match(T__0);
			setState(163);
			function_term(0);
			setState(164);
			match(T__1);
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

	public static class Function_parenthesed_expressionContext extends ParserRuleContext {
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public Function_parenthesed_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parenthesed_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_parenthesed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_parenthesed_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_parenthesed_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parenthesed_expressionContext function_parenthesed_expression() throws RecognitionException {
		Function_parenthesed_expressionContext _localctx = new Function_parenthesed_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function_parenthesed_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__0);
			setState(167);
			function_term(0);
			setState(168);
			match(T__1);
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

	public static class Function_termContext extends ParserRuleContext {
		public Function_factorContext function_factor() {
			return getRuleContext(Function_factorContext.class,0);
		}
		public Function_termContext function_term() {
			return getRuleContext(Function_termContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CalculatorExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorExpressionParser.MINUS, 0); }
		public Function_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_termContext function_term() throws RecognitionException {
		return function_term(0);
	}

	private Function_termContext function_term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_termContext _localctx = new Function_termContext(_ctx, _parentState);
		Function_termContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_function_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(171);
			function_factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(179);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(173);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(174);
						match(PLUS);
						setState(175);
						function_factor(0);
						}
						break;
					case 2:
						{
						_localctx = new Function_termContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_term);
						setState(176);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(177);
						match(MINUS);
						setState(178);
						function_factor(0);
						}
						break;
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_factorContext extends ParserRuleContext {
		public Function_powContext function_pow() {
			return getRuleContext(Function_powContext.class,0);
		}
		public Function_factorContext function_factor() {
			return getRuleContext(Function_factorContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CalculatorExpressionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorExpressionParser.DIV, 0); }
		public Function_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_factor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_factor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_factorContext function_factor() throws RecognitionException {
		return function_factor(0);
	}

	private Function_factorContext function_factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_factorContext _localctx = new Function_factorContext(_ctx, _parentState);
		Function_factorContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_function_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(185);
			function_pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(187);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(188);
						match(MULT);
						setState(189);
						function_pow(0);
						}
						break;
					case 2:
						{
						_localctx = new Function_factorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_function_factor);
						setState(190);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(191);
						match(DIV);
						setState(192);
						function_pow(0);
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_powContext extends ParserRuleContext {
		public Function_valueContext function_value() {
			return getRuleContext(Function_valueContext.class,0);
		}
		public Function_powContext function_pow() {
			return getRuleContext(Function_powContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalculatorExpressionParser.POW, 0); }
		public Function_powContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_pow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_pow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_pow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_powContext function_pow() throws RecognitionException {
		return function_pow(0);
	}

	private Function_powContext function_pow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_powContext _localctx = new Function_powContext(_ctx, _parentState);
		Function_powContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_function_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			function_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Function_powContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_function_pow);
					setState(201);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(202);
					match(POW);
					setState(203);
					function_value();
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_valueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Function_function_callContext function_function_call() {
			return getRuleContext(Function_function_callContext.class,0);
		}
		public Function_parenthesed_expressionContext function_parenthesed_expression() {
			return getRuleContext(Function_parenthesed_expressionContext.class,0);
		}
		public Function_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterFunction_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitFunction_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitFunction_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_valueContext function_value() throws RecognitionException {
		Function_valueContext _localctx = new Function_valueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_value);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DECIMAL:
			case IMAGINARY:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				number();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				variable();
				}
				break;
			case FUNCTION_IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				function_function_call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				function_parenthesed_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorExpressionListener ) ((CalculatorExpressionListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorExpressionVisitor ) return ((CalculatorExpressionVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__3);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return equivalence_sempred((EquivalenceContext)_localctx, predIndex);
		case 4:
			return implication_sempred((ImplicationContext)_localctx, predIndex);
		case 5:
			return disjunction_sempred((DisjunctionContext)_localctx, predIndex);
		case 6:
			return conjunction_sempred((ConjunctionContext)_localctx, predIndex);
		case 8:
			return term_sempred((TermContext)_localctx, predIndex);
		case 9:
			return factor_sempred((FactorContext)_localctx, predIndex);
		case 10:
			return pow_sempred((PowContext)_localctx, predIndex);
		case 16:
			return function_term_sempred((Function_termContext)_localctx, predIndex);
		case 17:
			return function_factor_sempred((Function_factorContext)_localctx, predIndex);
		case 18:
			return function_pow_sempred((Function_powContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean equivalence_sempred(EquivalenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean implication_sempred(ImplicationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean disjunction_sempred(DisjunctionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conjunction_sempred(ConjunctionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pow_sempred(PowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_term_sempred(Function_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_factor_sempred(Function_factorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean function_pow_sempred(Function_powContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00dc\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\5\2/\n\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"d\n\b\f\b\16\bg\13\b\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\nw\n\n\f\n\16\nz\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\r\3\r\3\r\3\r\5\r\u0099\n\r\3\16"+
		"\5\16\u009c\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u00b6\n\22\f\22\16\22\u00b9\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00c4\n\23\f\23\16\23\u00c7\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u00cf\n\24\f\24\16\24\u00d2\13\24\3\25\3\25\3\25\3\25"+
		"\5\25\u00d8\n\25\3\26\3\26\3\26\2\f\b\n\f\16\22\24\26\"$&\27\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3\2\7\t\2\u00de\2.\3\2\2\2\4"+
		"\60\3\2\2\2\6\64\3\2\2\2\b9\3\2\2\2\nD\3\2\2\2\fO\3\2\2\2\16]\3\2\2\2"+
		"\20k\3\2\2\2\22m\3\2\2\2\24{\3\2\2\2\26\u0089\3\2\2\2\30\u0098\3\2\2\2"+
		"\32\u009b\3\2\2\2\34\u009f\3\2\2\2\36\u00a3\3\2\2\2 \u00a8\3\2\2\2\"\u00ac"+
		"\3\2\2\2$\u00ba\3\2\2\2&\u00c8\3\2\2\2(\u00d7\3\2\2\2*\u00d9\3\2\2\2,"+
		"/\5\b\5\2-/\5\34\17\2.,\3\2\2\2.-\3\2\2\2/\3\3\2\2\2\60\61\7\3\2\2\61"+
		"\62\5\2\2\2\62\63\7\4\2\2\63\5\3\2\2\2\64\65\7\26\2\2\65\66\7\3\2\2\66"+
		"\67\5\22\n\2\678\7\4\2\28\7\3\2\2\29:\b\5\1\2:;\5\n\6\2;A\3\2\2\2<=\f"+
		"\3\2\2=>\7\25\2\2>@\5\n\6\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t"+
		"\3\2\2\2CA\3\2\2\2DE\b\6\1\2EF\5\f\7\2FL\3\2\2\2GH\f\3\2\2HI\7\24\2\2"+
		"IK\5\f\7\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2"+
		"\2OP\b\7\1\2PQ\5\16\b\2QZ\3\2\2\2RS\f\4\2\2ST\7\21\2\2TY\5\16\b\2UV\f"+
		"\3\2\2VW\7\23\2\2WY\5\16\b\2XR\3\2\2\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2"+
		"Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]^\b\b\1\2^_\5\20\t\2_e\3\2\2\2`a\f\3"+
		"\2\2ab\7\22\2\2bd\5\20\t\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\17"+
		"\3\2\2\2ge\3\2\2\2hl\5\22\n\2ij\7\20\2\2jl\5\22\n\2kh\3\2\2\2ki\3\2\2"+
		"\2l\21\3\2\2\2mn\b\n\1\2no\5\24\13\2ox\3\2\2\2pq\f\4\2\2qr\7\13\2\2rw"+
		"\5\24\13\2st\f\3\2\2tu\7\f\2\2uw\5\24\13\2vp\3\2\2\2vs\3\2\2\2wz\3\2\2"+
		"\2xv\3\2\2\2xy\3\2\2\2y\23\3\2\2\2zx\3\2\2\2{|\b\13\1\2|}\5\26\f\2}\u0086"+
		"\3\2\2\2~\177\f\4\2\2\177\u0080\7\r\2\2\u0080\u0085\5\26\f\2\u0081\u0082"+
		"\f\3\2\2\u0082\u0083\7\16\2\2\u0083\u0085\5\26\f\2\u0084~\3\2\2\2\u0084"+
		"\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\b\f\1\2\u008a\u008b"+
		"\5\30\r\2\u008b\u0091\3\2\2\2\u008c\u008d\f\3\2\2\u008d\u008e\7\17\2\2"+
		"\u008e\u0090\5\30\r\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\27\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0099\5\32\16\2\u0095\u0099\7\n\2\2\u0096\u0099\5\6\4\2\u0097\u0099\5"+
		"\4\3\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\31\3\2\2\2\u009a\u009c\7\f\2\2\u009b\u009a\3\2\2"+
		"\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\t\2\2\2\u009e\33"+
		"\3\2\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\5\"\22\2"+
		"\u00a2\35\3\2\2\2\u00a3\u00a4\7\26\2\2\u00a4\u00a5\7\3\2\2\u00a5\u00a6"+
		"\5\"\22\2\u00a6\u00a7\7\4\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\3\2\2\u00a9"+
		"\u00aa\5\"\22\2\u00aa\u00ab\7\4\2\2\u00ab!\3\2\2\2\u00ac\u00ad\b\22\1"+
		"\2\u00ad\u00ae\5$\23\2\u00ae\u00b7\3\2\2\2\u00af\u00b0\f\4\2\2\u00b0\u00b1"+
		"\7\13\2\2\u00b1\u00b6\5$\23\2\u00b2\u00b3\f\3\2\2\u00b3\u00b4\7\f\2\2"+
		"\u00b4\u00b6\5$\23\2\u00b5\u00af\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b6\u00b9"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8#\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\b\23\1\2\u00bb\u00bc\5&\24\2\u00bc\u00c5\3"+
		"\2\2\2\u00bd\u00be\f\4\2\2\u00be\u00bf\7\r\2\2\u00bf\u00c4\5&\24\2\u00c0"+
		"\u00c1\f\3\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c4\5&\24\2\u00c3\u00bd\3"+
		"\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6%\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\b\24\1\2"+
		"\u00c9\u00ca\5(\25\2\u00ca\u00d0\3\2\2\2\u00cb\u00cc\f\3\2\2\u00cc\u00cd"+
		"\7\17\2\2\u00cd\u00cf\5(\25\2\u00ce\u00cb\3\2\2\2\u00cf\u00d2\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\'\3\2\2\2\u00d2\u00d0\3"+
		"\2\2\2\u00d3\u00d8\5\32\16\2\u00d4\u00d8\5*\26\2\u00d5\u00d8\5\36\20\2"+
		"\u00d6\u00d8\5 \21\2\u00d7\u00d3\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8)\3\2\2\2\u00d9\u00da\7\6\2\2\u00da"+
		"+\3\2\2\2\26.ALXZekvx\u0084\u0086\u0091\u0098\u009b\u00b5\u00b7\u00c3"+
		"\u00c5\u00d0\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}