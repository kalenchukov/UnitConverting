/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.unit.converting;

import dev.kalenchukov.unit.converting.resources.MassMeasure;
import dev.kalenchukov.unit.converting.resources.Measurable;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractQuantityTest
{

	/**
	 * Проверка метода {@link AbstractQuantity#getQuantity()}.
	 */
	@Test
	public void getQuantity()
	{
		assertEquals(
			new BigDecimal(1),
			new MassQuantity(1, MassMeasure.GRAM).getQuantity()
		);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#getMeasure()}.
	 */
	@Test
	public void getMeasure()
	{
		assertEquals(
			MassMeasure.GRAM,
			new MassQuantity(1, MassMeasure.GRAM).getMeasure()
		);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#convert(Measurable)}.
	 */
	@Test
	public void testConvert()
	{
		assertEquals(
			new BigDecimal(1000),
			new MassQuantity(1, MassMeasure.KILOGRAM).convert(MassMeasure.GRAM)
		);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#convert(Measurable)} с нулевым значением.
	 */
	@Test()
	public void testConvertZero()
	{
		assertEquals(
			BigDecimal.ZERO,
			new MassQuantity(0, MassMeasure.GRAM).convert(MassMeasure.KILOGRAM)
		);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением большего значения.
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
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением равного значения.
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
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением меньшего значения.
	 */
	@Test
	public void testCompareToLess()
	{
		int result = new MassQuantity(1, MassMeasure.ZETTAGRAM).compareTo(
			new MassQuantity(1, MassMeasure.YOTTAGRAM)
		);

		assertEquals(-1, result);
	}
}