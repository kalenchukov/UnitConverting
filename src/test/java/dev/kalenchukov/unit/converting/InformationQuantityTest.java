/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unit.converting;

import dev.kalenchukov.unit.converting.resources.InformationMeasure;
import dev.kalenchukov.unit.converting.resources.Standard;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InformationQuantityTest
{
	/**
	 * Проверка отрицательной величины.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeQuality()
	{
		new InformationQuantity(-1, InformationMeasure.BYTE);
	}

	/**
	 * Проверка нуля в качестве величины.
	 */
	@Test()
	public void testZeroQuality()
	{
		assertEquals(
			BigDecimal.ZERO,
			new InformationQuantity(0, InformationMeasure.BYTE).convert(InformationMeasure.BIT)
		);
	}

	/**
	 * Проверка конвертирования величин.
	 */
	@Test
	public void testConvert()
	{
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.KIBIBIT).convert(InformationMeasure.BIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.MEBIBIT).convert(InformationMeasure.KIBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.GIBIBIT).convert(InformationMeasure.MEBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.TEBIBIT).convert(InformationMeasure.GIBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.PEBIBIT).convert(InformationMeasure.TEBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.EXBIBIT).convert(InformationMeasure.PEBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.ZEBIBIT).convert(InformationMeasure.EXBIBIT));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.YOBIBIT).convert(InformationMeasure.ZEBIBIT));

		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.KILOBIT).convert(InformationMeasure.BIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.MEGABIT).convert(InformationMeasure.KILOBIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.GIGABIT).convert(InformationMeasure.MEGABIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.TERABIT).convert(InformationMeasure.GIGABIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.PETABIT).convert(InformationMeasure.TERABIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.EXABIT).convert(InformationMeasure.PETABIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.ZETTABIT).convert(InformationMeasure.EXABIT));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.YOTTABIT).convert(InformationMeasure.ZETTABIT));

		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.KIBIBYTE).convert(InformationMeasure.BYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.MEBIBYTE).convert(InformationMeasure.KIBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.GIBIBYTE).convert(InformationMeasure.MEBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.TEBIBYTE).convert(InformationMeasure.GIBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.PEBIBYTE).convert(InformationMeasure.TEBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.EXBIBYTE).convert(InformationMeasure.PEBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.ZEBIBYTE).convert(InformationMeasure.EXBIBYTE));
		assertEquals(new BigDecimal("1024"), new InformationQuantity(1, InformationMeasure.YOBIBYTE).convert(InformationMeasure.ZEBIBYTE));

		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.KILOBYTE).convert(InformationMeasure.BYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.MEGABYTE).convert(InformationMeasure.KILOBYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.GIGABYTE).convert(InformationMeasure.MEGABYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.TERABYTE).convert(InformationMeasure.GIGABYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.PETABYTE).convert(InformationMeasure.TERABYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.EXABYTE).convert(InformationMeasure.PETABYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.ZETTABYTE).convert(InformationMeasure.EXABYTE));
		assertEquals(new BigDecimal("1000"), new InformationQuantity(1, InformationMeasure.YOTTABYTE).convert(InformationMeasure.ZETTABYTE));
	}

	/**
	 * Проверка сравнения большего значения.
	 */
	@Test
	public void testCompareToMore()
	{
		int result = new InformationQuantity(1, InformationMeasure.YOBIBIT).compareTo(
			new InformationQuantity(1, InformationMeasure.ZEBIBIT)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка сравнения равного значения.
	 */
	@Test
	public void testCompareToEqually()
	{
		int result = new InformationQuantity(1, InformationMeasure.MEBIBIT).compareTo(
			new InformationQuantity(1, InformationMeasure.MEBIBIT)
		);

		assertEquals(0, result);
	}

	/**
	 * Проверка сравнения меньшего значения.
	 */
	@Test
	public void testCompareToLess()
	{
		int result = new InformationQuantity(1, InformationMeasure.ZEBIBIT).compareTo(
			new InformationQuantity(1, InformationMeasure.YOBIBIT)
		);

		assertEquals(-1, result);
	}

	/**
	 * Проверка сравнения большего значения с меньшим.
	 */
	@Test
	public void testCompareMore()
	{
		int result = InformationQuantity.compare(
			new InformationQuantity(1, InformationMeasure.YOBIBIT),
			new InformationQuantity(1, InformationMeasure.ZEBIBIT)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка сравнения равных значений.
	 */
	@Test
	public void testCompareEqually()
	{
		int result = InformationQuantity.compare(
			new InformationQuantity(1, InformationMeasure.MEBIBIT),
			new InformationQuantity(1, InformationMeasure.MEBIBIT)
		);

		assertEquals(0, result);
	}

	/**
	 * Проверка сравнения меньшего значения с большим.
	 */
	@Test
	public void testCompareLess()
	{
		int result = InformationQuantity.compare(
			new InformationQuantity(1, InformationMeasure.ZEBIBIT),
			new InformationQuantity(1, InformationMeasure.YOBIBIT)
		);

		assertEquals(-1, result);
	}

	/**
	 * Проверка получения наименьшей меры.
	 */
	@Test
	public void testGetMin()
	{
		assertEquals(InformationMeasure.BIT, InformationMeasure.getMin());
	}

	/**
	 * Проверка получения наибольшей меры.
	 */
	@Test
	public void testGetMax()
	{
		assertEquals(InformationMeasure.YOBIBYTE, InformationMeasure.getMax());
	}

	/**
	 * Проверка получения наименьшей меры по стандарту.
	 */
	@Test
	public void testGetMinStandard()
	{
		assertEquals(InformationMeasure.BIT, InformationMeasure.getMin(Standard.IEC));
	}

	/**
	 * Проверка получения наибольшей меры по стандарту.
	 */
	@Test
	public void testGetMaxStandard()
	{
		assertEquals(InformationMeasure.YOBIBYTE, InformationMeasure.getMax(Standard.IEC));
	}

	/**
	 * Проверка сравнения разных объектов.
	 */
	@Test
	public void testEqualsDiffer()
	{
		// Разница в мере измерения
		assertFalse(new InformationQuantity(1, InformationMeasure.BYTE).equals(
			new InformationQuantity(1, InformationMeasure.KILOBYTE))
		);

		// Разница в величине
		assertFalse(new InformationQuantity(1, InformationMeasure.BYTE).equals(
			new InformationQuantity(2, InformationMeasure.BYTE))
		);

		// Разница в мере измерения и величине
		assertFalse(new InformationQuantity(1, InformationMeasure.BYTE).equals(
			new InformationQuantity(3, InformationMeasure.KILOBYTE))
		);
	}

	/**
	 * Проверка сравнения одинаковых объектов.
	 */
	@Test
	public void testEqualsIdentical()
	{
		assertTrue(new InformationQuantity(1, InformationMeasure.BYTE).equals(
			new InformationQuantity(1, InformationMeasure.BYTE))
		);
	}
}