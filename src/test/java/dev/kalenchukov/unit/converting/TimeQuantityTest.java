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

import dev.kalenchukov.unit.converting.resources.TimeMeasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link TimeQuantity}.
 *
 * @author Aleksey Kalenchukov
 */
public class TimeQuantityTest
{
	/**
	 * Проверка создания объекта {@link TimeQuantity} с отрицательной величиной.
	 */
	@Test
	public void testNegativeQuality()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new TimeQuantity(-1, TimeMeasure.SECOND);
		});
	}

	/**
	 * Проверка метода {@link TimeQuantity#compare(TimeQuantity, TimeQuantity)} со
	 * сравнением большего значения с меньшим.
	 */
	@Test
	public void testCompareMore()
	{
		int result = TimeQuantity.compare(
			new TimeQuantity(1, TimeMeasure.QUETTASECOND),
			new TimeQuantity(1, TimeMeasure.RONNASECOND)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка метода {@link TimeQuantity#compare(TimeQuantity, TimeQuantity)} со
	 * сравнением равных значений.
	 */
	@Test
	public void testCompareEqually()
	{
		int result = TimeQuantity.compare(
			new TimeQuantity(1, TimeMeasure.KILOSECOND),
			new TimeQuantity(1, TimeMeasure.KILOSECOND)
		);

		assertEquals(0, result);
	}

	/**
	 * Проверка метода {@link TimeQuantity#compare(TimeQuantity, TimeQuantity)} со
	 * сравнением меньшего значения с большим.
	 */
	@Test
	public void testCompareLess()
	{
		int result = TimeQuantity.compare(
			new TimeQuantity(1, TimeMeasure.RONNASECOND),
			new TimeQuantity(1, TimeMeasure.QUETTASECOND)
		);

		assertEquals(-1, result);
	}

	/**
	 * Проверка метода {@link TimeQuantity#equals(Object)}.
	 */
	@Test
	public void testEquals()
	{
		assertEquals(
			new TimeQuantity(1, TimeMeasure.SECOND),
			new TimeQuantity(1, TimeMeasure.SECOND)
		);
	}

	/**
	 * Проверка метода {@link TimeQuantity#equals(Object)} с разными объектами.
	 */
	@Test
	public void testEqualsNotCorrect()
	{
		// Разница в мере измерения
		assertNotEquals(
			new TimeQuantity(1, TimeMeasure.SECOND),
			new TimeQuantity(1, TimeMeasure.KILOSECOND)
		);

		// Разница в величине
		assertNotEquals(
			new TimeQuantity(1, TimeMeasure.SECOND),
			new TimeQuantity(2, TimeMeasure.SECOND)
		);

		// Разница в мере измерения и величине
		assertNotEquals(
			new TimeQuantity(1, TimeMeasure.SECOND),
			new TimeQuantity(3, TimeMeasure.KILOSECOND)
		);
	}
}