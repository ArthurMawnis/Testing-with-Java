package com.arthur.testing;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.arthur.exceptions.NoPossibleTriangleException;
import com.arthur.utils.TriangleUtils;

class TestingApplicationTests {

	private static final String ISOSCELES = "isosceles";
	private static final String EQUILATERAL = "equilateral";
	private static final String SCALENE = "scalene";

	@Test
	void should_return_ISOSCELES_when_two_equals_sides() {
		// Given two equals sides and a different one
		final Float a = 7f;
		final Float b = 7f;
		final Float c = 6f;

		String result1 = null;
		String result2 = null;

		try {
			// When
			result1 = TriangleUtils.printTriangleType(a, b, c);
			result2 = TriangleUtils.printTriangleType(c, b, a);
		} catch (NoPossibleTriangleException e) {
			fail(e.getMessage());
		}
		// Assert this is a isosceles
		Assertions.assertEquals(ISOSCELES, result1);
		Assertions.assertEquals(ISOSCELES, result2);
	}

	@Test
	void should_return_EQUILATERAL_when_all_equals_sides() {
		// Given three equals sides
		final Float a = 5f;
		final Float b = a;
		final Float c = b;

		String result = null;
		try {
			// When
			result = TriangleUtils.printTriangleType(a, b, c);
		} catch (NoPossibleTriangleException e) {
			fail(e.getMessage());
		}
		// Assert this is a equilateral
		Assertions.assertEquals(EQUILATERAL, result);
	}

	@Test
	void should_return_SCALENE_when_all_different_sides() {
		// Given three different sides
		final Float a = 5f;
		final Float b = 6f;
		final Float c = 7f;

		String result = null;
		try {
			// When
			result = TriangleUtils.printTriangleType(a, b, c);
		} catch (NoPossibleTriangleException e) {
			fail(e.getMessage());
		}
		// Assert this is a scalene
		Assertions.assertEquals(SCALENE, result);
	}
}
