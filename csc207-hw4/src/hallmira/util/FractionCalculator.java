package hallmira.util;
import hallmira.util.Fraction;

import hallmira.util.StringUtils;
	
	
public class FractionCalculator {
	
public static String stub(String line)throws Exception{
	if (line.equals(new String("Bad"))){
		throw new badEntry("this entry is Bad. Try again");
	}else 
	return line;
	}//if

public static Fraction evaluate(String expr) throws Exception{
	/*
	 * Base for this procedure was taken from Andrew Kelley's 
	 * homework 3 for csc207. This included the cases for
	 *  +,-,*,/,^.
	 */
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
		return answer;
} //evaluate(String)

public static boolean fractionCheck(String[] expressions) {
	for (int x = 0; x < expressions.length; x++) {
		if(expressions[x].charAt(0) == '(')
			return true;
	}
	return false;
}
}



