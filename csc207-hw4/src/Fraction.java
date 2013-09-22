import java.lang.Math;
import java.lang.Number.BigInteger;
public class Fraction {
	
		///adapted from csc207-hw2 by Mira Hall and Matt Dole
			/**
			 * A helpful introductory comment that describes the class.
			 */

			// +--------+---------------------------------------------------------
			// | Fields |
			// +--------+
			public double numerator;
			public double denominator;

			private void simplify(){
				double ratio = (double) this.numerator/this.denominator;
				if ((int)ratio == ratio){
					this.numerator = (int) ratio;
					this.denominator = 1;
				}else {
					this.denominator = Math.round(this.denominator);
					this.numerator = Math.round(ratio * this.denominator);
				}
			}
			// +--------------+---------------------------------------------------
			// | Constructors |
			// +--------------+
			public Fraction(int num, int denom)throws Exception{
				this.numerator = num;
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = denom;
				}
				
			}
			
			public Fraction(double num, double denom)throws Exception{
				this.numerator = num;
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = denom;
				}
				simplify();
			}
			public Fraction(double value){
				if ((int) value == value){
					this.numerator = value;
					this.denominator = 1;
				}else 
			}
			public Fraction(String str)throws Exception{
				this.numerator = ;
				if (denom == 0){
					throw new Exception("denominator cannot be 0");
				}else {
					this.denominator = denom;
				}
				simplify();
			}
				
			// +---------+--------------------------------------------------------
			// | Methods |
			// +---------+
			
			
			public double getNum() {
				return this.numerator; //STUB
			}//getNum

			/**
			 * Gets the denominator of a Fraction number
			 * Observer
			 */
			public double getDenom() {
				return this.denominator; //STUB
			}//getDenom
			
			/**
			 * adds this Fraction number to another Fraction number
			 * returns their sum
			 * (Observer/Constructor)
			 *
			 */
			public Fraction add(Fraction additor) {
				if(this.denominator != additor.denominator){
					BigInteger = 
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
			 * Observer/Constructor
			 */
			public Fraction multiply(double multiplicand) {
				return null; //STUB
			}//multiply
			
			/**
			 * divides Fraction by divisor
			 * returns their Fraction/divisor
			 * Observer/Constructor
			 */
			public static Fraction divide(double divisor) {
				return null; //STUB
			}//divide

			
			/**
			 * Finds the reciporcal of this Fraction number
			 * Mutator
			 */
			public void reciprocal() {
			 //STUB
			}//reciprocal

			/**
			 * Changes Fraction to the absolute value of this Fraction number
			 * Mutator
			 */
			public void absVal() {
			 //STUB
			}//absVal
			/**
			 *Negates Fraction. If Fraction is negative, changes to positive
			 *If Fraction is positive, changes to negative
			 *(Mutator)
			 */
			public void negate() {
				//STUB
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
