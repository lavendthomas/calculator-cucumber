// Generated from /home/thomas/Desktop/calc/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorExpressionParser}.
 */
public interface CalculatorExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(CalculatorExpressionParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(CalculatorExpressionParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#equivalence}.
	 * @param ctx the parse tree
	 */
	void enterEquivalence(CalculatorExpressionParser.EquivalenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#equivalence}.
	 * @param ctx the parse tree
	 */
	void exitEquivalence(CalculatorExpressionParser.EquivalenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#implication}.
	 * @param ctx the parse tree
	 */
	void enterImplication(CalculatorExpressionParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#implication}.
	 * @param ctx the parse tree
	 */
	void exitImplication(CalculatorExpressionParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(CalculatorExpressionParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(CalculatorExpressionParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(CalculatorExpressionParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(CalculatorExpressionParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CalculatorExpressionParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CalculatorExpressionParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(CalculatorExpressionParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(CalculatorExpressionParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CalculatorExpressionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CalculatorExpressionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalculatorExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalculatorExpressionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_defintion}.
	 * @param ctx the parse tree
	 */
	void enterFunction_defintion(CalculatorExpressionParser.Function_defintionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_defintion}.
	 * @param ctx the parse tree
	 */
	void exitFunction_defintion(CalculatorExpressionParser.Function_defintionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_function_call(CalculatorExpressionParser.Function_function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_function_call(CalculatorExpressionParser.Function_function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parenthesed_expression(CalculatorExpressionParser.Function_parenthesed_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_parenthesed_expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parenthesed_expression(CalculatorExpressionParser.Function_parenthesed_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_term}.
	 * @param ctx the parse tree
	 */
	void enterFunction_term(CalculatorExpressionParser.Function_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_term}.
	 * @param ctx the parse tree
	 */
	void exitFunction_term(CalculatorExpressionParser.Function_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_factor}.
	 * @param ctx the parse tree
	 */
	void enterFunction_factor(CalculatorExpressionParser.Function_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_factor}.
	 * @param ctx the parse tree
	 */
	void exitFunction_factor(CalculatorExpressionParser.Function_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_pow}.
	 * @param ctx the parse tree
	 */
	void enterFunction_pow(CalculatorExpressionParser.Function_powContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_pow}.
	 * @param ctx the parse tree
	 */
	void exitFunction_pow(CalculatorExpressionParser.Function_powContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#function_value}.
	 * @param ctx the parse tree
	 */
	void enterFunction_value(CalculatorExpressionParser.Function_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#function_value}.
	 * @param ctx the parse tree
	 */
	void exitFunction_value(CalculatorExpressionParser.Function_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CalculatorExpressionParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CalculatorExpressionParser.VariableContext ctx);
}