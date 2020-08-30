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
	
	private TriangleUtils() {}

	/**
	 * Verify if a triangle is:
	 * 1) A Scalene when all sides are different
	 * 2) A Equilateral when all sides are equals
	 * 3) A Isosceles when theres two equal sides
	 * 
	 * @param First side
	 * @param Second side
	 * @param Third side
	 * @return Triangle type
	 * @throws NoPossibleTriangleException
	 */
	public static String printTriangleType(final Float s1, final Float s2, final Float s3)
			throws NoPossibleTriangleException {
		if (s1.equals(s2) && s2.equals(s3)) {
			System.out.println(EQUILATERAL);
			return EQUILATERAL;
		}

		if ((s1.equals(s2) && !s1.equals(s3)) 
				|| (s1.equals(s3) && !s1.equals(s2))
				|| (s2.equals(s3) && !s1.equals(s2))) {
			System.out.println(ISOSCELES);
			return ISOSCELES;
		}

		if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3)) {
			System.out.println(SCALENE);
			return SCALENE;
		}

		throw new NoPossibleTriangleException();
	}
}
