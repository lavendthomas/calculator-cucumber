// Generated from /home/thomas/Desktop/calc/src/main/resources/CalculatorExpression.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalculatorExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#parenthesed_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(CalculatorExpressionParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#equivalence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalence(CalculatorExpressionParser.EquivalenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#implication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(CalculatorExpressionParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(CalculatorExpressionParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(CalculatorExpressionParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(CalculatorExpressionParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CalculatorExpressionParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(CalculatorExpressionParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(CalculatorExpressionParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CalculatorExpressionParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalculatorExpressionParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_defintion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_defintion(CalculatorExpressionParser.Function_defintionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_function_call(CalculatorExpressionParser.Function_function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_parenthesed_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parenthesed_expression(CalculatorExpressionParser.Function_parenthesed_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_term(CalculatorExpressionParser.Function_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_factor(CalculatorExpressionParser.Function_factorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_pow(CalculatorExpressionParser.Function_powContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#function_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_value(CalculatorExpressionParser.Function_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorExpressionParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CalculatorExpressionParser.VariableContext ctx);
}