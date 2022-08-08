/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unit.converting;

import dev.kalenchukov.unit.converting.resources.MassMeasure;
import dev.kalenchukov.unit.converting.resources.Standard;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MassQuantityTest
{
	/**
	 * Проверка отрицательной величины.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeQuality()
	{
		new MassQuantity(-1, MassMeasure.GRAM);
	}

	/**
	 * Проверка нуля в качестве величины.
	 */
	@Test()
	public void testZeroQuality()
	{
		assertEquals(
			BigDecimal.ZERO,
			new MassQuantity(0, MassMeasure.GRAM).convert(MassMeasure.KILOGRAM)
		);
	}

	/**
	 * Проверка конвертирования величин.
	 */
	@Test
	public void testConvert()
	{
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.ZEPTOGRAM).convert(MassMeasure.YOCTOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.ATTOGRAM).convert(MassMeasure.ZEPTOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.FEMTOGRAM).convert(MassMeasure.ATTOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.PICOGRAM).convert(MassMeasure.FEMTOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.NANOGRAM).convert(MassMeasure.PICOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.MICROGRAM).convert(MassMeasure.NANOGRAM));
		assertEquals(new BigDecimal("1E+3"), new MassQuantity(1, MassMeasure.MILLIGRAM).convert(MassMeasure.MICROGRAM));

		assertEquals(new BigDecimal("1E+1"), new MassQuantity(1, MassMeasure.CENTIGRAM).convert(MassMeasure.MILLIGRAM));
		assertEquals(new BigDecimal("1E+1"), new MassQuantity(1, MassMeasure.DECIGRAM).convert(MassMeasure.CENTIGRAM));
		assertEquals(new BigDecimal("1E+1"), new MassQuantity(1, MassMeasure.GRAM).convert(MassMeasure.DECIGRAM));

		assertEquals(new BigDecimal("10"), new MassQuantity(1, MassMeasure.DECAGRAM).convert(MassMeasure.GRAM));
		assertEquals(new BigDecimal("10"), new MassQuantity(1, MassMeasure.HECTOGRAM).convert(MassMeasure.DECAGRAM));
		assertEquals(new BigDecimal("10"), new MassQuantity(1, MassMeasure.KILOGRAM).convert(MassMeasure.HECTOGRAM));

		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.MEGAGRAM).convert(MassMeasure.KILOGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.GIGAGRAM).convert(MassMeasure.MEGAGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.TERAGRAM).convert(MassMeasure.GIGAGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.PETAGRAM).convert(MassMeasure.TERAGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.EXAGRAM).convert(MassMeasure.PETAGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.ZETTAGRAM).convert(MassMeasure.EXAGRAM));
		assertEquals(new BigDecimal("1000"), new MassQuantity(1, MassMeasure.YOTTAGRAM).convert(MassMeasure.ZETTAGRAM));
	}

	/**
	 * Проверка сравнения большего значения.
	 */
	@Test
	public void testCompareToMore()
	{
		int result = new MassQuantity(1, MassMeasure.YOTTAGRAM).compareTo(
			new MassQuantity(1, MassMeasure.ZETTAGRAM)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка сравнения равного значения.
	 */
	@Test
	public void testCompareToEqually()
	{
		int result = new MassQuantity(1, MassMeasure.KILOGRAM).compareTo(
			new MassQuantity(1, MassMeasure.KILOGRAM)
		);

		assertEquals(0, result);
	}

	/**
	 * Проверка сравнения меньшего значения.
	 */
	@Test
	public void testCompareToLess()
	{
		int result = new MassQuantity(1, MassMeasure.ZETTAGRAM).compareTo(
			new MassQuantity(1, MassMeasure.YOTTAGRAM)
		);

		assertEquals(-1, result);
	}

	/**
	 * Проверка сравнения большего значения с меньшим.
	 */
	@Test
	public void testCompareMore()
	{
		int result = MassQuantity.compare(
			new MassQuantity(1, MassMeasure.YOTTAGRAM),
			new MassQuantity(1, MassMeasure.ZETTAGRAM)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка сравнения равных значений.
	 */
	@Test
	public void testCompareEqually()
	{
		int result = MassQuantity.compare(
			new MassQuantity(1, MassMeasure.KILOGRAM),
			new MassQuantity(1, MassMeasure.KILOGRAM)
		);

		assertEquals(0, result);
	}

	/**
	 * Проверка сравнения меньшего значения с большим.
	 */
	@Test
	public void testCompareLess()
	{
		int result = MassQuantity.compare(
			new MassQuantity(1, MassMeasure.ZETTAGRAM),
			new MassQuantity(1, MassMeasure.YOTTAGRAM)
		);

		assertEquals(-1, result);
	}

	/**
	 * Проверка получения наименьшей меры.
	 */
	@Test
	public void testGetMin()
	{
		assertEquals(MassMeasure.YOCTOGRAM, MassMeasure.getMin());
	}

	/**
	 * Проверка получения наибольшей меры.
	 */
	@Test
	public void testGetMax()
	{
		assertEquals(MassMeasure.YOTTAGRAM, MassMeasure.getMax());
	}

	/**
	 * Проверка получения наименьшей меры по стандарту.
	 */
	@Test
	public void testGetMinStandard()
	{
		assertEquals(MassMeasure.YOCTOGRAM, MassMeasure.getMin(Standard.SI));
	}

	/**
	 * Проверка получения наибольшей меры по стандарту.
	 */
	@Test
	public void testGetMaxStandard()
	{
		assertEquals(MassMeasure.YOTTAGRAM, MassMeasure.getMax(Standard.SI));
	}

	/**
	 * Проверка сравнения разных объектов.
	 */
	@Test
	public void testEqualsDiffer()
	{
		// Разница в мере измерения
		assertFalse(new MassQuantity(1, MassMeasure.GRAM).equals(
			new MassQuantity(1, MassMeasure.KILOGRAM))
		);

		// Разница в величине
		assertFalse(new MassQuantity(1, MassMeasure.GRAM).equals(
			new MassQuantity(2, MassMeasure.GRAM))
		);

		// Разница в мере измерения и величине
		assertFalse(new MassQuantity(1, MassMeasure.GRAM).equals(
			new MassQuantity(3, MassMeasure.KILOGRAM))
		);
	}

	/**
	 * Проверка сравнения одинаковых объектов.
	 */
	@Test
	public void testEqualsIdentical()
	{
		assertTrue(new MassQuantity(1, MassMeasure.GRAM).equals(
			new MassQuantity(1, MassMeasure.GRAM))
		);
	}
}