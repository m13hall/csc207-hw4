package hallmira.util;
import hallmira.util.Fraction;
import java.math.BigInteger;
import hallmira.util.StringUtils;

/**
 * 
 * @author Andrew Kelley
 * @author Mira Hall
 * memory values initialized to zero
 */
public class FractionCalculator {
	 /**
     * A fraction array field to store variables
     */
    Fraction[] mem = new Fraction[8];

    /**
     * FractionCalculator is a calculator object that has the ability to
     * store up to 9 variables in the form r0...r8.
     * Initializes memory values to zero.
     * @throws Exception if fractions are not formed correctly
     */ 
    public FractionCalculator() throws Exception{
        for(int x = 0; x < mem.length; x++) {
            mem[x] = new Fraction(0,1);
        }
    }

    /**
     * evaluate takes an expression and gives back a fraction that is the answer to
     * expression. 
     * @param expr, a mathematical expression in string form. Please input fractions as "x/y" with
     * no spaces in between any parts of the fraction statement. All other parts of the expressoin
     * must be separated by spaces as follows: "x + y + z/c" would be a valid expression.
     * @return a fraction that is the answer to the expression
     * @throws Exception if there is a reference to a non-existent memory location, or fraction is
     * misformed. 
     */
    public Fraction evaluate(String expr) throws Exception{
        /*
         * Base for this procedure was taken from Andrew Kelley's 
         * homework 3 for csc207. This included the cases for
         *  +,-,*,/,^.
         */
        //if the expression is an initialization
        //remember the storingLocation and evaluate as normal, ignoring the "rx ="
        BigInteger memLoc;
        int storingLocation = -1;
        if (expr.indexOf('=') != -1) {
            String[] storingExpr = StringUtils.splitAt(expr, '=');
            if (storingExpr[0].charAt(0) == 'r') {
                memLoc = new BigInteger((storingExpr[0].substring(1)).trim());
                storingLocation = memLoc.intValue();
                expr = storingExpr[1].trim();
            }else {
                throw new badEntry("invalid memory location");
            }
        } 
        //replace any memory locations with their values
        StringBuffer memCheck = new StringBuffer(expr);
        
        int nextMem = memCheck.indexOf("r");
        while(nextMem != -1){ //while any r's are found, replace them
            String nextMemLocStr = memCheck.substring(nextMem+1, nextMem + 2);
            int nextMemLoc = new BigInteger(nextMemLocStr).intValue();
            
            if(0 <= nextMemLoc && nextMemLoc <= 8){ //check if valid memory location
                memCheck.replace(nextMem, nextMem + 2, this.mem[nextMemLoc].toString());
            }else {
                throw new badEntry("memory location r"+ nextMemLocStr + " is invalid");
            }
            nextMem = memCheck.indexOf("r");
        }
        expr = memCheck.toString(); //update expr with memory values subbed in
        
        //evaluate the expression with memory values replaced with their assigned values
        String[] expression = StringUtils.splitAt(expr, ' ');
        
        Fraction answer = new Fraction(expression[0]);
        for (int x = 1; x < expression.length; x++) {
            String op = expression[x];
            if (op.charAt(0) == '+') {
                answer = answer.add(new Fraction(expression[x + 1]));
            }
            else if (op.charAt(0) == '-') {
                answer = answer.subtract(new Fraction(expression[x + 1]));
            }
            else if (op.charAt(0) == '*') {
                answer = answer.multiply(new Fraction(expression[x + 1]));
            }
            else if (op.charAt(0) == '/') {
                answer = answer.divide(new Fraction(expression[x + 1]));
            }
            else if (op.charAt(0) == '^') {
                answer = answer.toPower(new Integer(expression[x + 1]));
            }

        }
        //if we were storing a location, store it as well as return it
        if(storingLocation != -1) {
            mem[storingLocation] = answer;
        }
        return answer;
    } //evaluate(String)
    
    /**
     * evaluate takes an array of string expressions and evaluates them, returning
     * an array of fraction answers using the evaluate function above.
     * @param exprArray, a string array of expressions
     * @return answerArray, a fraction array of answers
     * @throws Exception if fractions are formed incorrectly
     */
    public Fraction[] evaluate(String[] exprArray) throws Exception{
        int len = exprArray.length;
        Fraction[] answerArray = new Fraction[len];
        for(int x = 0; x < len; x++){
            answerArray[x] = this.evaluate(exprArray[x]);
        }
        return answerArray;
    }
}