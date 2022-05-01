package visitor;

import calculator.*;
import calculator.operation.*;
import calculator.operation.buildinfunctions.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
import parser.CalculatorExpressionParser;
import parser.CalculatorExpressionVisitor;

import java.math.BigDecimal;
import java.util.List;

public class SyntaxTreeVisitor implements CalculatorExpressionVisitor<Expression> {

    Calculator calculator;

    public SyntaxTreeVisitor(Calculator calc) {
        calculator = calc;
    }

    private Expression term(ParserRuleContext ctx) {
        return switch(ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression term = ctx.getChild(0).accept(this);
                Expression factor = ctx.getChild(2).accept(this);
                TerminalNodeImpl symbol = (TerminalNodeImpl) ctx.getChild(1);
                List<Expression> elist = List.of(term, factor);
                try {
                    yield switch (symbol.getSymbol().getType()) {
                        case CalculatorExpressionParser.PLUS -> new Plus(elist);
                        case CalculatorExpressionParser.MINUS -> new Minus(elist);
                        default -> throw new InvalidSyntax("The term uses an unknown symbol");
                    };
                } catch (IllegalConstruction e) {
                    throw new InvalidSyntax("Could not create the operator");
                }

            }
            default -> throw new InvalidSyntax("Term has an unknown amount of children.");
        };
    }

    private Expression factor(ParserRuleContext ctx) {
        return switch(ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression factor = ctx.getChild(0).accept(this);
                Expression value = ctx.getChild(2).accept(this);
                TerminalNodeImpl symbol = (TerminalNodeImpl) ctx.getChild(1);
                List<Expression> elist = List.of(factor, value);
                try {
                    yield switch (symbol.getSymbol().getType()) {
                        case CalculatorExpressionParser.MULT -> new Times(elist);
                        case CalculatorExpressionParser.DIV -> new Divides(elist);
                        default -> throw new InvalidSyntax("The term uses an unknown symbol");
                    };
                } catch (IllegalConstruction e) {
                    throw new InvalidSyntax("Could not create the operator");
                }

            }
            default -> throw new InvalidSyntax("Term has an unknown amount of children.");
        };
    }

    private Expression pow(ParserRuleContext ctx) {
        return switch(ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression base = ctx.getChild(0).accept(this);
                Expression power = ctx.getChild(2).accept(this);
                List<Expression> elist = List.of(base, power);
                try{
                    yield new Pow(elist);
                } catch (IllegalConstruction e) {
                    throw new InvalidSyntax("Could not create the operator");
                }

            }
            default -> throw new InvalidSyntax("Pow has an unknown amount of children.");
        };
    }

    private Expression function(ParserRuleContext ctx) {
        Expression argument = ctx.getChild(2).accept(this);
        String functionName = ctx.getChild(0).getText();
        try {
            return switch (functionName) {
                case "abs"       -> new Abs(argument);
                case "acos"      -> new Acos(argument);
                case "asin"      -> new Asin(argument);
                case "asinh"     -> new Asinh(argument);
                case "atan"      -> new Atan(argument);
                case "atanh"     -> new Atanh(argument);
                case "cbrt"      -> new Cbrt(argument);
                case "cos"       -> new Cos(argument);
                case "cosh"      -> new Cosh(argument);
                case "exp"       -> new Exp(argument);
                case "identity"  -> new Identity(argument);
                case "ln"        -> new Ln(argument);
                case "log"       -> new Log(argument);
                case "sin"       -> new Sin(argument);
                case "sinh"      -> new Sinh(argument);
                case "sqrt"      -> new Sqrt(argument);
                case "tan"       -> new Tan(argument);
                case "tanh"      -> new Tanh(argument);
                default -> {
                    // There is no built-in function
                    if (!calculator.hasFunction(functionName)) {
                        throw new RuntimeException("No function called " + functionName + " exists.");
                    }
                    Function fn = calculator.getFunction(functionName);
                    fn.accept(new VariableAssignerVisitor(argument)); // Set the value ?

                    yield fn;
                }

            };
        } catch (IllegalConstruction e) {
            throw new RuntimeException("Could not instantiate function called " + functionName);
        }
    }

    @Override
    public Expression visitExpression(CalculatorExpressionParser.ExpressionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitParenthesed_expression(CalculatorExpressionParser.Parenthesed_expressionContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Expression visitFunction_call(CalculatorExpressionParser.Function_callContext ctx) {
        return function(ctx);
    }

    @Override
    public Expression visitEquivalence(CalculatorExpressionParser.EquivalenceContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression equivalence = ctx.getChild(0).accept(this);
                Expression implication = ctx.getChild(2).accept(this);
                try {
                    yield new LogicalEquivalence(List.of(equivalence, implication));
                } catch (IllegalConstruction e) {
                    throw new RuntimeException("Could not create LogicalEquivalence");
                }
            }
            default -> throw new RuntimeException("Illegal amount of children in visitEquivalence");
        };
    }

    @Override
    public Expression visitImplication(CalculatorExpressionParser.ImplicationContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression implication = ctx.getChild(0).accept(this);
                Expression disjunction = ctx.getChild(2).accept(this);
                try {
                    yield new LogicalImplication(List.of(implication, disjunction));
                } catch (IllegalConstruction e) {
                    throw new RuntimeException("Could not create LogicalEquivalence");
                }
            }
            default -> throw new RuntimeException("Illegal amount of children in visitEquivalence");
        };
    }

    @Override
    public Expression visitDisjunction(CalculatorExpressionParser.DisjunctionContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression disjunction = ctx.getChild(0).accept(this);
                Expression conjunction = ctx.getChild(2).accept(this);
                TerminalNodeImpl operator = (TerminalNodeImpl) ctx.getChild(1);
                List<Expression> elist = List.of(disjunction, conjunction);

                try {
                    yield switch (operator.getSymbol().getType()) {
                        case CalculatorExpressionParser.LOGICAL_OR -> new LogicalOr(elist);
                        case CalculatorExpressionParser.LOGICAL_XOR -> new LogicalXor(elist);
                        default -> throw new RuntimeException("Should be a OR or XOR operation");
                    };
                } catch (IllegalConstruction e) {
                    throw new RuntimeException("Could not create LogicalEquivalence");
                }
            }
            default -> throw new RuntimeException("Illegal amount of children in visitEquivalence");
        };
    }

    @Override
    public Expression visitConjunction(CalculatorExpressionParser.ConjunctionContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 3 -> {
                Expression conjunction = ctx.getChild(0).accept(this);
                Expression negation = ctx.getChild(2).accept(this);
                try {
                    yield new LogicalAnd(List.of(conjunction, negation));
                } catch (IllegalConstruction e) {
                    throw new RuntimeException("Could not create LogicalAnd");
                }
            }
            default -> throw new RuntimeException("Illegal amount of children in visitEquivalence");
        };
    }

    @Override
    public Expression visitNegation(CalculatorExpressionParser.NegationContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> ctx.getChild(0).accept(this);
            case 2 -> {
                Expression term = ctx.getChild(1).accept(this);
                try {
                    yield new LogicalNot(List.of(term));
                } catch (IllegalConstruction e) {
                    throw new RuntimeException("Could not create LogicalNot");
                }
            }
            default -> throw new RuntimeException("Illegal amount of children in visitEquivalence");
        };
    }

    @Override
    public Expression visitTerm(CalculatorExpressionParser.TermContext ctx) {
        return term(ctx);
    }

    @Override
    public Expression visitFactor(CalculatorExpressionParser.FactorContext ctx) {
        return factor(ctx);
    }

    @Override
    public Expression visitPow(CalculatorExpressionParser.PowContext ctx) {
        return pow(ctx);
    }

    @Override
    public Expression visitValue(CalculatorExpressionParser.ValueContext ctx) {
        // Always one child, whether it is a number or an expression
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitNumber(CalculatorExpressionParser.NumberContext ctx) {
        return switch (ctx.getChildCount()) {
            case 1 -> {
                // The number is the value of the child.
                assert ctx.getChild(0) instanceof TerminalNodeImpl;
                TerminalNodeImpl nb = (TerminalNodeImpl) ctx.getChild(0);
                yield switch (nb.getSymbol().getType()) {
                    case CalculatorExpressionParser.INT -> new Rational(Integer.parseInt(nb.getText()));
                    case CalculatorExpressionParser.DECIMAL -> new Real(nb.getText());
                    case CalculatorExpressionParser.IMAGINARY -> {
                        BigDecimal imaginary = nb.getText().length() == 1 ? BigDecimal.ONE : BigDecimal.valueOf(Integer.parseInt(nb.getText().substring(0, nb.getText().length()-1)));
                        yield new Complex(BigDecimal.ZERO, imaginary);
                    }
                    default -> throw new InvalidSyntax("Invalid number");
                };
            }
            case 2 -> {
                assert ((TerminalNodeImpl) ctx.getChild(0)).getSymbol().getType() == CalculatorExpressionParser.MINUS;
                assert ctx.getChild(1) instanceof TerminalNodeImpl;
                TerminalNodeImpl nb = (TerminalNodeImpl) ctx.getChild(1);
                yield switch (nb.getSymbol().getType()) {
                    case CalculatorExpressionParser.INT -> new Rational(Integer.parseInt(nb.getText())).negate();
                    case CalculatorExpressionParser.DECIMAL -> new Real(nb.getText()).negate();
                    case CalculatorExpressionParser.IMAGINARY -> {
                        BigDecimal imaginary = nb.getText().length() == 1 ? BigDecimal.ONE : BigDecimal.valueOf(Integer.parseInt(nb.getText().substring(0, nb.getText().length()-1)));
                        yield new Complex(BigDecimal.ZERO, imaginary).negate();
                    }
                    default -> throw new InvalidSyntax("Invalid number");
                };
            }
            default -> throw new InvalidSyntax("Unknown number of children.");
        };

    }

    @Override
    public Expression visitFunction_defintion(CalculatorExpressionParser.Function_defintionContext ctx) {
        String functionName = ctx.getChild(0).getText();
        Expression subExpr = ctx.getChild(2).accept(this);
        Function f = new Function(functionName, subExpr);
        calculator.addFunction(f);
        return f;
    }

    @Override
    public Expression visitFunction_function_call(CalculatorExpressionParser.Function_function_callContext ctx) {
        return function(ctx);
    }

    @Override
    public Expression visitFunction_parenthesed_expression(CalculatorExpressionParser.Function_parenthesed_expressionContext ctx) {
        return ctx.getChild(1).accept(this);
    }

    @Override
    public Expression visitFunction_term(CalculatorExpressionParser.Function_termContext ctx) {
        return term(ctx);
    }

    @Override
    public Expression visitFunction_factor(CalculatorExpressionParser.Function_factorContext ctx) {
        return factor(ctx);
    }

    @Override
    public Expression visitFunction_pow(CalculatorExpressionParser.Function_powContext ctx) {
        return pow(ctx);
    }

    @Override
    public Expression visitFunction_value(CalculatorExpressionParser.Function_valueContext ctx) {
        // Always one child, whether it is a number or an expression
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Expression visitVariable(CalculatorExpressionParser.VariableContext ctx) {
        return new Variable(ctx.getChild(0).getText());
    }

    @Override
    public Expression visit(ParseTree parseTree) {
        return parseTree.getChild(0).accept(this); // The only child of an expression is a term.
    }

    @Override
    public Expression visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Expression visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Expression visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
