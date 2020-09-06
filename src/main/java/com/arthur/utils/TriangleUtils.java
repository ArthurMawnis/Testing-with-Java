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
	public static String printTriangleType(final Float ab, final Float bc, final Float ca)
			throws NoPossibleTriangleException {
		checkOnlyValidSides(ab, bc, ca);
		assertInequality(ab, bc, ca);

		if (ab.equals(bc) && bc.equals(ca))
			return EQUILATERAL;

		if ((ab.equals(bc)) || (ab.equals(ca)) || (bc.equals(ca)))
			return ISOSCELES;

		return SCALENE;
	}

	/**
	 * Check if all sides are positive non-zero numbers
	 * 
	 * @param ab
	 * @param bc
	 * @param ca
	 * @throws NoPossibleTriangleException
	 */
	private static void checkOnlyValidSides(Float ab, Float bc, Float ca) throws NoPossibleTriangleException {
		if (!validPositiveInteger(ab) || !validPositiveInteger(bc) || !validPositiveInteger(ca))
			throw new NoPossibleTriangleException();

	}

	/**
	 * Check if a given number N is a non-zero positive number
	 * 
	 * @param n
	 * @return
	 */
	private static boolean validPositiveInteger(Float n) {
		if (n != null) {
			return n > 0;
		}
		return false;
	}

	/**
	 * Check if the given fall into triangle inequality theorem
	 * 
	 * @param ab
	 * @param bc
	 * @param ca
	 * @throws NoPossibleTriangleException
	 */
	private static void assertInequality(final Float ab, final Float bc, final Float ca)
			throws NoPossibleTriangleException {
		boolean a = ab < bc + ca;
		boolean b = bc < ab + ca;
		boolean c = ca < ab + bc;

		if (!(a && b && c)) {
			throw new NoPossibleTriangleException();
		}
	}
}
