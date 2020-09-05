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
	void should_return_isosceles_when_two_equals_sides() {
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
	void should_return_equilateral_when_all_equals_sides() {
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
	void should_return_scalene_when_all_different_sides() {
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

	@Test
	void should_throw_exception_when_invalid_sizes_for_scalene() {
		// Given three different sides that doesnt complete a triangle due to inequality
		// theorem
		final Float a = 16f;
		final Float b = 22f;
		final Float c = 40f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_invalid_sizes_for_isosceles() {
		// longest side is always shorter than the sum of the other two.
		final Float a = 10f;
		final Float b = 10f;
		final Float c = 21f;
		// 21 > 10 + 10
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_return_isosceles_within_all_possible_permutations() {
		final Float a = 7f;
		final Float b = 7f;
		final Float c = 6f;

		// Assert this is a isosceles
		try {
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(a, b, c));
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(a, c, b));
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(b, a, c));
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(b, c, a));
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(c, a, b));
			Assertions.assertEquals(ISOSCELES, TriangleUtils.printTriangleType(c, b, a));
		} catch (NoPossibleTriangleException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	void should_throw_exception_when_theres_a_side_equals_zero() {
		final Float a = 0f;
		final Float b = 10f;
		final Float c = 7f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_theres_a_negative_side() {
		final Float a = -6f;
		final Float b = 10f;
		final Float c = 7f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_sum_of_two_sides_equals_the_third_side() {
		// longest side is always shorter than the sum of the other two.
		final Float a = 10f;
		final Float b = 10f;
		final Float c = 20f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_sum_of_two_sides_equals_the_third_side_within_permutation() {
		final Float a = 10f;
		final Float b = 10f;
		final Float c = 20f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, c, b));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(b, a, c));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(b, c, a));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(c, a, b));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(c, b, a));
	}

	@Test
	void should_throw_exception_when_sum_of_two_is_greater_than_third_side() {
		final Float a = 1f;
		final Float b = 2f;
		final Float c = 4f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_sum_of_two_is_greater_than_third_side_within_permutation() {
		final Float a = 1f;
		final Float b = 2f;
		final Float c = 4f;

		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, c, b));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(b, a, c));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(b, c, a));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(c, a, b));
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(c, b, a));
	}

	@Test
	void should_throw_exception_when_all_sides_are_zero() {
		final Float a = 0f;
		final Float b = 0f;
		final Float c = 0f;
		//not equilateral!!!
		Assertions.assertThrows(NoPossibleTriangleException.class, () -> TriangleUtils.printTriangleType(a, b, c));
	}

	@Test
	void should_throw_exception_when_theres_not_three_input_number() {
	}

}
