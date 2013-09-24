

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
		assertEquals(new Fraction(1, 8), oneEigth);//doesn't work
	}
	
	@Test
	public void testCompare() throws Exception {
		assertTrue("1/3 < 1/2", ((new Fraction(1,3)).compareTo(new Fraction(1,2))) < 0);
	}
	/*
	 * ...HERE and we still need to make a compare method...
	 */
	@Test 
	public void test_simplify() throws Exception{
		Fraction oneHalf = new Fraction(4, 8);
		Fraction oneEigth = new Fraction(.125);
		Fraction fiveEigths = new Fraction(16.15, 25.84);
		assertEquals("test simplify", BigInteger.valueOf(2), oneHalf.getDenom());
		assertEquals("test simplify", BigInteger.valueOf(8), fiveEigths.getNum());
		assertEquals(new Fraction(1, 8), oneEigth);//doesn't work
		//assertEquals(true, oneEigth.equals(new Fraction(1,8))); //apparently also doesn't work??
		//this uses the equals(fraction) one i wrote but inexplicably thinks that true && true is false?????
		//?????????????????????????????????????????????

	}
	
	@Test 
	public void test_add() throws Exception{
		
		Fraction oneHalf = new Fraction(4, 8);
		Fraction oneEigth = new Fraction(.125);
		Fraction fiveEigths = new Fraction(16.15, 25.84);
		Fraction threeFourths = new Fraction(12, 16);
		assertEquals(true, threeFourths.equals(fiveEigths.add(oneEigth)));
	}
}
