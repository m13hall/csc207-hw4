/**
			 * @author Andrew Kelley
			 * @author Mira Hall
			 * */

package hallmira.util;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class FractionTest {
	
	
	@Test
	public void test_getNumDenom() throws Exception {
		Fraction threeFourths = new Fraction(3, 4);
		Fraction oneThird = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
		Fraction twoFifths = new Fraction((int) 2, (int)5);
		Fraction threeTenths = new Fraction(.3);
		
		assertEquals(BigInteger.valueOf(3), threeFourths.getNum());
		assertEquals(BigInteger.valueOf(3), oneThird.getDenom());
		assertEquals(BigInteger.valueOf(3), threeTenths.getNum());
		
		
		
		try{
			Fraction f = new Fraction(1,0);
			fail("Zero Denominator");
		}catch (Exception e){
		}
	}
	
	/*
	 * SAM'S TESTS RIGHT HERE TO...
	 */
	@Test
	public void testEquality() throws Exception {
		assertEquals("1/2 = 2/4", new Fraction(1,2), new Fraction(2,4));
		Fraction oneEigth = new Fraction(.125);
		//assertEquals(new Fraction(1, 8), oneEigth);//doesn't work
	}
	
	@Test
	public void testCompare() throws Exception {
		assertTrue("1/3 < 1/2", ((new Fraction(1,3)).compareTo(new Fraction(1,2))) < 0);
		assertTrue("1/4 < 1/3", ((new Fraction(1,4)).compareTo(new Fraction(1,3))) < 0);
		assertTrue("1/5 = 5/25", ((new Fraction(1,5)).compareTo(new Fraction(5,25))) == 0);
		assertTrue("1/5 > 1/6", ((new Fraction(1,5)).compareTo(new Fraction(1,6))) > 0);
	}
	/*
	 * ...HERE and we still need to make a compare method...
	 */
	@Test 
	public void test_simplify() throws Exception{
		Fraction oneHalf = new Fraction(4, 8);
		Fraction oneEigth = new Fraction(.125);
		Fraction fiveEigths = new Fraction(10.23, 15.9);
		assertEquals("test simplify", new Fraction(1, 2), oneHalf);
		assertEquals("test simplify", new Fraction(5, 8), fiveEigths);
		assertEquals(new Fraction(1, 8), oneEigth);

	}
	
	@Test 
	public void test_addSubtract() throws Exception{
		
		Fraction oneEigth = new Fraction(.125);
		Fraction negativeOneEigth = new Fraction(-1,8);
		Fraction fiveEigths = new Fraction(10.23, 15.9);
		Fraction threeFourths = new Fraction(12, 16);
		Fraction zero = new Fraction(0);
		assertEquals(threeFourths, fiveEigths.add(oneEigth));
		assertEquals(fiveEigths, threeFourths.add(negativeOneEigth));
		assertEquals(zero, oneEigth.add(negativeOneEigth));
		assertEquals(zero, oneEigth.subtract(oneEigth));
	}
	
	@Test
	public void test_multiplyDivide() throws Exception{
		Fraction oneHalf = new Fraction(.5);
		Fraction two = new Fraction(2);
		Fraction oneFourth = new Fraction(.25);
		Fraction eight = new Fraction(8);
		Fraction one = new Fraction(1);
		
		assertEquals(oneHalf, one.divide(two));
		assertEquals(oneHalf, one.multiply(oneHalf));
		assertEquals(oneFourth, one.multiply(oneHalf).multiply(oneHalf));
		assertEquals(eight, two.divide(oneFourth));
	}
	
	@Test
	public void test_reciprocal() throws Exception{
		assertEquals(new Fraction(8), (new Fraction(1, 8)).reciprocal());
		assertEquals(new Fraction(2), (new Fraction(1, 2)).reciprocal());
		assertEquals(new Fraction(1,2), (new Fraction(2)).reciprocal());
		assertEquals(new Fraction(1,8), (new Fraction(8)).reciprocal());
	}

	@Test
	public void test_absVal() throws Exception{
		assertEquals(new Fraction(7), (new Fraction(-7)).absVal());
		assertEquals(new Fraction(7), (new Fraction(7)).absVal());
		assertEquals(new Fraction(3,8), (new Fraction(-3,8)).absVal());
		assertEquals(new Fraction(3,8), (new Fraction(3,8)).absVal());
	}
	
	@Test
	public void test_negate() throws Exception{
		assertEquals(new Fraction(-1,9), (new Fraction(1,9).negate()));
		assertEquals(new Fraction(1,9), (new Fraction(-1,9).negate()));
		assertEquals(new Fraction(-7,11), (new Fraction(7,11).negate()));
		assertEquals(new Fraction(7,11), (new Fraction(-7,11).negate()));
	}
	
	@Test
	public void test_toPower() throws Exception{
		assertEquals(new Fraction(1,8), (new Fraction(1,2).toPower(3)));
		assertEquals(new Fraction(1,9), (new Fraction(1,3).toPower(2)));
		assertEquals(new Fraction(9,16), (new Fraction(3,4).toPower(2)));
		assertEquals(new Fraction(16,25), (new Fraction(4,5).toPower(2)));
	}
	
	@Test
	public void test_wholePart() throws Exception{
		assertEquals(new BigInteger("1"), (new Fraction(3,2)).wholePart());
		assertEquals(new BigInteger("2"), (new Fraction(7,3)).wholePart());
		assertEquals(new BigInteger("3"), (new Fraction(13,4)).wholePart());
		assertEquals(new BigInteger("4"), (new Fraction(24,5)).wholePart());
	}
	
	@Test
	public void test_fractionPart() throws Exception{
		assertEquals(new Fraction(1,2), (new Fraction(3,2)).fractionPart());
		assertEquals(new Fraction(1,3), (new Fraction(7,3)).fractionPart());
		assertEquals(new Fraction(1,4), (new Fraction(13,4)).fractionPart());
		assertEquals(new Fraction(4,5), (new Fraction(24,5)).fractionPart());
	}
	
	@Test
	public void test_toString() throws Exception{
		assertEquals(new String("3/4"), (new Fraction(3,4).toString()));
		assertEquals(new String("7/8"), (new Fraction(7,8).toString()));
		assertEquals(new String("1/8"), (new Fraction(3,24).toString()));
		assertEquals(new String("7/5"), (new Fraction(7,5).toString()));
	}
	@Test
	public void test_FractionCalculator() throws Exception{
		FractionCalculator calc = new FractionCalculator();
		assertEquals(new Fraction(1,2), calc.evaluate("1/4 + 1/4"));
		assertEquals(new Fraction(1,2), calc.evaluate("r0 = 1/2"));
		assertEquals(new Fraction(3, 2), calc.evaluate("r0 + 1"));
		assertEquals(new Fraction (5, 8), calc.evaluate("r1 = r0 + 1/8"));
		assertEquals(new Fraction(5, 16), calc.evaluate("r1 * r0"));
		
		Fraction[] fracsOut = {new Fraction(1,2), new Fraction(3,4), new Fraction(0, 1)};
		String[] fracsIn = {"r0 = 1/2", "r1 = r0 + 1/4", "r1 - 3/4"};
		Fraction[] fracsActuallyOut = calc.evaluate(fracsIn);
		for(int x = 0; x < fracsOut.length; x++){
			assertEquals(fracsOut[x], fracsActuallyOut[x]);
		}
	}
}
