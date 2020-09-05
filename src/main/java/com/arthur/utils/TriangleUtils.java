package com.arthur.utils;

import com.arthur.exceptions.NoPossibleTriangleException;

/**
 * @author Arthur Freitas
 *
 *
 */
public class TriangleUtils {

	private static final String ISOSCELES = "isosceles";
	private static final String EQUILATERAL = "equilateral";
	private static final String SCALENE = "scalene";

	private TriangleUtils() {
	}

	/**
	 * Verify if a triangle is: 1) A Scalene when all sides are different 2) A
	 * Equilateral when all sides are equals 3) A Isosceles when theres two equal
	 * sides
	 * 
	 * @param First  side
	 * @param Second side
	 * @param Third  side
	 * @return Triangle type
	 * @throws NoPossibleTriangleException
	 */
	public static String printTriangleType(final Float s1, final Float s2, final Float s3)
			throws NoPossibleTriangleException {
		checkOnlyValidSides(s1, s2, s3);

		if (s1.equals(s2) && s2.equals(s3)) {
			System.out.println(EQUILATERAL);
			return EQUILATERAL;
		}

		if ((s1.equals(s2) && !s1.equals(s3)) || (s1.equals(s3) && !s1.equals(s2))
				|| (s2.equals(s3) && !s1.equals(s2))) {

			if (!assertInequality(s1, s2, s3))
				throw new NoPossibleTriangleException();

			System.out.println(ISOSCELES);
			return ISOSCELES;
		}

		if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3)) {
			if (!assertInequality(s1, s2, s3))
				throw new NoPossibleTriangleException();

			System.out.println(SCALENE);
			return SCALENE;
		}

		throw new NoPossibleTriangleException();
	}

	private static void checkOnlyValidSides(Float s1, Float s2, Float s3) throws NoPossibleTriangleException {
		if(s1 <= 0 || s2 <= 0 || s3 <= 0)
			throw new NoPossibleTriangleException();
		
	}

	private static boolean assertInequality(final Float s1, final Float s2, final Float s3) {
		boolean a = s1 < s2 + s3;
		boolean b = s2 < s1 + s3;
		boolean c = s3 < s1 + s2;

		return a && b && c;
	}
}
