

package hallmira.util;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import java.lang.Math;

public class FractionTest {
//TEST
	@Test
	public void test_getNum() throws Exception {
		Fraction threeFourths = new Fraction(3, 4);
		Fraction oneThird = new Fraction(new BigInteger.valueOf(3), BigInteger.valueOf("4"));
		assertEquals(BigInteger.valueOf(3), threeFourths.getNum());
		//assertEquals(BigInteger.valueOf(3), oneThird.getDenom());
		try{
			Fraction f = new Fraction(1,0);
			fail("Zero Denominator");
		}catch (Exception e){
			
		}
	}

}
