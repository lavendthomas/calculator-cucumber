package calculator;

import visitor.Evaluator;
import visitor.InfixPrinter;
import visitor.Printer;

import java.util.HashMap;

public class Calculator {

    /*
     For the moment the calculator only contains a print method and an eval method
     It would be useful to complete this with a read method, so that we would be able
     to implement a full REPL cycle (Read-Eval-Print loop) such as in Scheme, Python, R and other languages.
     To do so would require to implement a method with the following signature, converting an input string
     into an arithmetic expression:
     public Expression read(String s)
    */

    /**
     * This hashmap will contain all functions that are defined by a user
     */
    private HashMap<String, Function> userDefinedFunctions;

    public Calculator() {
        userDefinedFunctions = new HashMap<>();
    }



    /**
     *
     * @param f The function to store
     */
    public void addFunction(Function f) {
       userDefinedFunctions.put(f.name, f);
    }

    public boolean hasFunction(String functionName) {
        return userDefinedFunctions.containsKey(functionName);
    }

    public Expression apply(String functionName, Expression e) {
        Evaluator v = new Evaluator();
        userDefinedFunctions.get(functionName).accept(v); // TODO works?
        return v.getResult();
    }

    public Function getFunction(String functionName) {
        return userDefinedFunctions.get(functionName);
    }

    public String print(Expression e) {
        Printer p = new InfixPrinter();
        e.accept(p);
        return p.getBuffer();
    }


    public Number eval(Expression e) {
        // create a new visitor to evaluate expressions
        Evaluator v = new Evaluator();
        // and ask the expression to accept this visitor to start the evaluation process
        e.accept(v);
        // and return the result of the evaluation at the end of the process
        return v.getResult();
    }

    public MyBoolean evalBool(Expression e){
        Evaluator v = new Evaluator();
        try{
            e.accept(v);
        } catch (NullPointerException ex){
            System.out.println("expression cannot be null");
        }
        return v.getBoolResult();
    }



    /*
     We could also have other methods, e.g. to verify whether an expression is syntactically correct
     public Boolean validate(Expression e)
     or to simplify some expression
     public Expression simplify(Expression e)
    */
}
