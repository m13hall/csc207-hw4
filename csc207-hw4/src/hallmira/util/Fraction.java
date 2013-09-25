package hallmira.util;
import java.lang.Math;
import java.math.BigInteger;
public class Fraction {
	
		///adapted from csc207-hw2 by Mira Hall and Matt Dole
			/**
			 * @author Andrew Kelley
			 * @author Mira Hall
			 * This is a class that represents fractions. 
			 */

			// +--------+---------------------------------------------------------
			// | Fields |
			// +--------+
			public BigInteger numerator;
			public BigInteger denominator;
		
			// +--------------+---------------------------------------------------
			// | Constructors |
			// +--------------+
			public Fraction(int num, int denom)throws Exception{
				Integer Num = num;
				Integer Denom = denom;
				
				this.numerator = new BigInteger(Num.toString());
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = new BigInteger(Denom.toString());
				}
				this.simplify();
				
			}
			public Fraction(int num)throws Exception{
				Integer Num = num;
				this.numerator = new BigInteger(Num.toString());
				this.denominator = new BigInteger("1");
			}
			public Fraction(BigInteger num, BigInteger denom)throws Exception{
				this.numerator = num;
				if (denom == BigInteger.valueOf(0)){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = denom;
				}
				this.simplify();
			}
			
			public Fraction(BigInteger num)throws Exception{
				this.numerator = num;
				this.denominator = new BigInteger("1");
			}
			/**
			 * 
			 * @param num numerator
			 * @param denom denominator
			 * @throws Exception
			 * @returns a Fraction expressing approximately the same ratio as the double
			 * 
			 */
			public Fraction(double num, double denom)throws Exception{
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					double ratio = num/denom;
						Integer iDenom = (int)Math.round(denom);
						//multiply the rounded denominator by the correct ratio to 
						//get a close approximation of the correct numerator
						Integer iNum = (int) Math.round(ratio * Math.round(denom));
						this.denominator = new BigInteger(iDenom.toString());
						this.numerator = new BigInteger(iNum.toString());
				}
				this.simplify();
			}
			/**
			 * @returns a Fraction of the same ratio as expressed by the double
			 * algorithm from http://www.mathsisfun.com/converting-decimals-fractions.html accessed 9/23
			 * @param value 
			 * 
			 */
			//
			public Fraction(double value){
				//convert for processing
				Double val = value;
				String numStr = val.toString();
				//find the number of numbers past the decimal point
				int len = numStr.length() - numStr.indexOf('.') - 1;
				Integer multiplicand = (int) Math.pow(10, len);
				//multiply the value by the appropriate power of 10 to make a whole number
				Integer noDec = (int) (value * multiplicand);
				this.numerator = new BigInteger(noDec.toString());
				this.denominator = new BigInteger(multiplicand.toString());
				this.simplify();	
			}

			public Fraction(String str)throws Exception{
				String[] expressions = StringUtils.splitAt(str, '/');
				//what if there's more than one /? should we support that?
				if(expressions.length == 1) {
					this.numerator = new BigInteger(expressions[0]);
					this.denominator = new BigInteger("1");
				} else {
					this.numerator = new BigInteger(expressions[0].trim());
					BigInteger denom = new BigInteger(expressions[1].trim());
				
					if (denom.compareTo(new BigInteger("0")) == 0){
						throw new Exception("denominator cannot be 0");
					}else {
						this.denominator = denom;
					}
				}
				this.simplify();
			}
				
			// +---------+--------------------------------------------------------
			// | Methods |
			// +---------+
			
			private void simplify() {
				//simplify the fraction
				BigInteger gcd = this.numerator.gcd(this.denominator);
				this.numerator = this.numerator.divide(gcd);
				this.denominator = this.denominator.divide(gcd);
				
				//assure that the numerator carries the accurate sign for the whole fraction
				if (this.denominator.signum() == -1){
					this.numerator.negate();
				}
			}
			
			//from Sam Rebelsky's eBoard 9/23
			public boolean equals(Object other) {
		        return (other instanceof Fraction) && 
		                (this.equals((Fraction) other));
		    } // equals(Object)
			
			public boolean equals(Fraction other){
				boolean num = this.numerator.equals(other.numerator);
				boolean denom = this.denominator.equals(other.denominator);
				return (num && denom);
			}
			
			public BigInteger getNum() {
				return this.numerator; //STUB
			}//getNum

			/**
			 * Gets the denominator of a Fraction number
			 * Observer
			 */
			public BigInteger getDenom() {
				return this.denominator; //STUB
			}//getDenom
			
			/**
			 * adds this Fraction number to another Fraction number
			 * returns their sum
			 * (Observer/Constructor)
			 *
			 */
			public Fraction add(Fraction additor) throws Exception{
				if(this.denominator != additor.denominator){
					
					//new Denominator is non-common factors of the product of the denominators
					BigInteger newDenom = (this.denominator.multiply(additor.denominator));
					
					//new Numerator is the old numerator times whatever factors of the LCD the old Denominator missed
					BigInteger newNum = this.numerator.multiply(additor.denominator)
					.add(additor.numerator.multiply(this.denominator));
					
					return new Fraction(newNum, newDenom);
				
				} else 
					return new Fraction(this.numerator.add(additor.numerator), this.denominator);	
			}//add
			/**
			 * subtracts subtractor from Fraction
			 * returns Fraction-subtractor
			 * (Observer/Constructor)
			 *
			 */
			public Fraction subtract(Fraction subtractor) throws Exception{
					
					return this.add(subtractor.negate());
				
			}//subtract

			/**
			 * multiplies this Fraction number by another Fraction number * takes two Fraction numbers
			 * returns their product
			 * Constructor
			 */
			public Fraction multiply(Fraction multiplicand) throws Exception{
				Fraction product = new Fraction(
						this.numerator.multiply(multiplicand.numerator), 
						this.denominator.multiply(multiplicand.denominator));
				return product;
			}//multiply
			
			/**
			 * Finds the reciporcal of this Fraction number
			 * Constructor
			 */
			public Fraction reciprocal() throws Exception{
			 return new Fraction(this.denominator, this.numerator);
			}//reciprocal
			
			/**
			 * divides Fraction by divisor
			 * returns their Fraction/divisor
			 * Observer/Constructor
			 */
			public Fraction divide(Fraction divisor) throws Exception {
				 return this.multiply(divisor.reciprocal());
			}//divide


			/**
			 * Returns a Fraction equal to the absolute value of this Fraction number
			 * (Constructor)
			 */
			public Fraction absVal() throws Exception{
			 return new Fraction(this.numerator.abs(), this.denominator);
			}//absVal
			
			/**
			 *Returns negated Fraction. If Fraction is negative, changes to positive
			 *If Fraction is positive, changes to negative
			 *(Mutator)
			 */
			public Fraction negate() throws Exception{
				return new Fraction(this.numerator.negate(), this.denominator);
			}//absVal
			
			/**
			 * Returns a new Fraction number equal to Fraction raised 
			 * to an exponent (Constructor)
			 */
			public Fraction toPower(int exponent) throws Exception{
				return new Fraction(this.numerator.pow(exponent), this.denominator.pow(exponent));
			} //numeratorExponent


			/**
			 * Round a Fraction number to the nearest whole (Observer)
			 * (ie for 3/2 returns 1)
			 */
			public BigInteger wholePart() {
				return this.numerator.divide(this.denominator); //STUB
			}//FractionRound

			/**
			 * Returns the fractional part of a Fraction. (Constructor)
			 * (ie for 3/2 returns 1/2)
			 */
			public Fraction fractionPart() throws Exception{
				return new Fraction(this.numerator.mod(this.denominator), this.denominator);
			}//FractionRound
			
			/**
			 * Returns the fractional part of a Fraction. (Constructor)
			 * (ie for 3/2 returns 1/2)
			 */
			public String toString() {
				return this.numerator.toString() + "/" + this.denominator.toString(); //STUB
			}//FractionRound
			/**
			 * 
			 * @param frac Fraction object
			 * @return 
			 */
			public int compareTo(Fraction frac) {
				return this.numerator.multiply(frac.denominator).compareTo( 
						frac.numerator.multiply(this.denominator));
			}
			


}
