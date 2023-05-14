/*
 * Copyright © 2022-2023 Алексей Каленчуков
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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link MassQuantity}.
 *
 * @author Алексей Каленчуков
 */
public class MassQuantityTest
{
	/**
	 * Проверка создания объекта {@link MassQuantity} с отрицательной величиной.
	 */
	@Test
	public void testNegativeQuality()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new MassQuantity(-1, MassMeasure.GRAM);
		});
	}

	/**
	 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
	 * сравнением большего значения с меньшим.
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
	 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
	 * сравнением равных значений.
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
	 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
	 * сравнением меньшего значения с большим.
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
	 * Проверка метода {@link MassQuantity#equals(Object)}.
	 */
	@Test
	public void testEquals()
	{
		assertEquals(
			new MassQuantity(1, MassMeasure.GRAM),
			new MassQuantity(1, MassMeasure.GRAM)
		);
	}

	/**
	 * Проверка метода {@link MassQuantity#equals(Object)} с разными объектами.
	 */
	@Test
	public void testEqualsNotCorrect()
	{
		// Разница в мере измерения
		assertNotEquals(
			new MassQuantity(1, MassMeasure.GRAM),
			new MassQuantity(1, MassMeasure.KILOGRAM)
		);

		// Разница в величине
		assertNotEquals(
			new MassQuantity(1, MassMeasure.GRAM),
			new MassQuantity(2, MassMeasure.GRAM)
		);

		// Разница в мере измерения и величине
		assertNotEquals(
			new MassQuantity(1, MassMeasure.GRAM),
			new MassQuantity(3, MassMeasure.KILOGRAM)
		);
	}
}