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

package dev.kalenchukov.unit.converting.resources;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки констант и методов перечисления {@link MassMeasure}.
 */
class MassMeasureTest
{
	/**
	 * Проверка метода {@link MassMeasure#getStandard()}.
	 */
	@Test
	void getStandard()
	{
		assertArrayEquals(
			List.of(Standard.SI).toArray(),
			MassMeasure.KILOGRAM.getStandard().toArray()
		);
	}

	/**
	 * Проверка метода {@link MassMeasure#getCountMinUnit()}.
	 */
	@Test
	void getCountMinUnit()
	{
		assertEquals(BigDecimal.valueOf(1000), MassMeasure.KILOGRAM.getCountMinUnit());
	}

	/**
	 * Проверка метода {@link MassMeasure#getMin()}.
	 */
	@Test
	public void testGetMin()
	{
		assertEquals(MassMeasure.YOCTOGRAM, MassMeasure.getMin());
	}

	/**
	 * Проверка метода {@link MassMeasure#getMax()}.
	 */
	@Test
	public void testGetMax()
	{
		assertEquals(MassMeasure.YOTTAGRAM, MassMeasure.getMax());
	}

	/**
	 * Проверка метода {@link MassMeasure#getMin(Standard)}.
	 */
	@Test
	public void testGetMinStandard()
	{
		assertEquals(MassMeasure.YOCTOGRAM, MassMeasure.getMin(Standard.SI));
	}

	/**
	 * Проверка метода {@link MassMeasure#getMax(Standard)}.
	 */
	@Test
	public void testGetMaxStandard()
	{
		assertEquals(MassMeasure.YOTTAGRAM, MassMeasure.getMax(Standard.SI));
	}

}