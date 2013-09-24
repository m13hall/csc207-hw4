import java.lang.Math;
import java.math.BigInteger;
public class Fraction {
	
		///adapted from csc207-hw2 by Mira Hall and Matt Dole
			/**
			 * Numerator carries the sign.
			 */

			// +--------+---------------------------------------------------------
			// | Fields |
			// +--------+
			public BigInteger numerator;
			public BigInteger denominator;

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
		
			// +--------------+---------------------------------------------------
			// | Constructors |
			// +--------------+
			public Fraction(Integer num, Integer denom)throws Exception{
				this.numerator = new BigInteger(num.toString());
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = new BigInteger(denom.toString());
				}
				this.simplify();
				
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
			
			public Fraction(double num, double denom, double test)throws Exception{
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					double ratio = num/denom;
					Integer iRatio = (int) ratio;
					if (iRatio == ratio){
						this.numerator = new BigInteger(iRatio.toString());
						this.denominator = BigInteger.valueOf(1);
					}else {
						Integer iDenom = (int) denom;
						Integer iNum = (int) (ratio * denom);
						this.denominator = new BigInteger(iDenom.toString());
						this.numerator = new BigInteger(iNum.toString());
					}
				}
				this.simplify();
			}
			public Fraction(double num, double denom)throws Exception{
				Integer x = new Integer((int) num);
				this.numerator = new BigInteger(x.toString());
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					Integer y = new Integer((int) denom);
					this.denominator = new BigInteger(y.toString());
				}
				this.simplify();
			}
//			public Fraction(double value){
//				if ((int) value == value){
//					this.numerator = value;
//					this.denominator = new BigInteger("1");
//				}else 
//			}
			public Fraction(String str)throws Exception{
				String[] expressions = StringUtils.splitAt(str, '/');
				//what if there's more than one /? should we support that?
				this.numerator = new BigInteger(expressions[0].trim());
				
				BigInteger denom = new BigInteger(expressions[2].trim());
				
				if (denom.compareTo(new BigInteger("0")) == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = denom;
				}
				this.simplify();
			}
				
			// +---------+--------------------------------------------------------
			// | Methods |
			// +---------+
			
			public boolean equals(Object other) {
		        return this.equals((Fraction) other);
		    } // equals(Object)
			
			
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
					BigInteger gcd = this.denominator.gcd(additor.denominator);
					//new Denominator is non-common factors of the product of the denominators
					BigInteger newDenom = (this.denominator.multiply(additor.denominator)).divide(gcd);
					//new Numerator is the old numerator times whatever factors of the LCD the old Denominator missed
					BigInteger newNum = (this.numerator.multiply(newDenom.divide(this.denominator)))
					.add(additor.numerator.multiply(newDenom.divide(additor.denominator)));
					
					return new Fraction(newDenom, newNum);
					
				}
				return null; //STUB
			}//add
			/**
			 * subtracts subtractor from Fraction
			 * returns Fraction-subtractor
			 * (Observer/Constructor)
			 *
			 */
			public Fraction subtract(double additor) {
				return null; //STUB
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
			 * Changes Fraction to the absolute value of this Fraction number
			 * Mutator
			 */
			public void absVal() {
			 this.numerator.abs();
			}//absVal
			
			/**
			 *Negates Fraction. If Fraction is negative, changes to positive
			 *If Fraction is positive, changes to negative
			 *(Mutator)
			 */
			public void negate() {
				this.numerator.negate();
			}//absVal
			
			/**
			 * Raise Fraction number to an exponent (Mutator)
			 */
			public void toPower(double exponent) {
				//STUB
			} //numeratorExponent


			/**
			 * Round a Fraction number to the nearest whole (Observer)
			 * (ie for 3/2 returns 1)
			 */
			public int wholePart() {
				return 0; //STUB
			}//FractionRound

			/**
			 * Returns the fractional part of a Fraction. (Constructor)
			 * (ie for 3/2 returns 1/2)
			 */
			public Fraction fractionPart() {
				return null; //STUB
			}//FractionRound
			
			/**
			 * Returns the fractional part of a Fraction. (Constructor)
			 * (ie for 3/2 returns 1/2)
			 */
			public String toString() {
				return null; //STUB
			}//FractionRound
			
			/**
			 * Returns the fractional part of a Fraction. (Constructor)
			 * (ie for 3/2 returns 1/2)
			 */
			public String toString() {
				return null; //STUB
			}//FractionRound

			

}
