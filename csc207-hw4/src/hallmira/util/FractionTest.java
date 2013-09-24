package hallmira.util;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import java.lang.Math;

public class FractionTest {
//TEST
	@Test
	public void test_FractionFromBigInts() throws Exception {
		Fraction threeFourths = new Fraction(3, 4);
		assertEquals(BigInteger.valueOf(3), threeFourths.getNum());
	}

}
