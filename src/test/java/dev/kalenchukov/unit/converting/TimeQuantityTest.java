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
 * @author Алексей Каленчуков
 */
public class TimeQuantityTest
{
	/**
	 * Проверка создания объекта {@link TimeQuantity} с отрицательной величиной.
	 */
	@Test
	public void negativeQuality()
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
	public void compareMore()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.QUETTASECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.RONNASECOND);

		Integer actualCompare = TimeQuantity.compare(timeQuantity1, timeQuantity2);

		assertEquals(1, actualCompare);
	}

	/**
	 * Проверка метода {@link TimeQuantity#compare(TimeQuantity, TimeQuantity)} со
	 * сравнением равных значений.
	 */
	@Test
	public void compareEqually()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.KILOSECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.KILOSECOND);

		Integer actualCompare = TimeQuantity.compare(timeQuantity1, timeQuantity2);

		assertEquals(0, actualCompare);
	}

	/**
	 * Проверка метода {@link TimeQuantity#compare(TimeQuantity, TimeQuantity)} со
	 * сравнением меньшего значения с большим.
	 */
	@Test
	public void compareLess()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.RONNASECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.QUETTASECOND);

		Integer actualCompare = TimeQuantity.compare(timeQuantity1, timeQuantity2);

		assertEquals(-1, actualCompare);
	}

	/**
	 * Проверка метода {@link TimeQuantity#equals(Object)}.
	 */
	@Test
	public void testEquals()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.SECOND);

		boolean actual = timeQuantity1.equals(timeQuantity2);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link TimeQuantity#equals(Object)} с разными мерами измерения.
	 */
	@Test
	public void testEqualsDifferentMeasure()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.KILOSECOND);

		boolean actual = timeQuantity1.equals(timeQuantity2);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link TimeQuantity#equals(Object)} с разными величинами.
	 */
	@Test
	public void testEqualsDifferentQuantity()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(2, TimeMeasure.SECOND);

		boolean actual = timeQuantity1.equals(timeQuantity2);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link TimeQuantity#hashCode()}.
	 */
	@Test
	public void testHashCode()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.SECOND);

		Integer expectedHashCode = timeQuantity1.hashCode();
		Integer actualHashCode = timeQuantity2.hashCode();

		assertEquals(expectedHashCode, actualHashCode);
	}

	/**
	 * Проверка метода {@link TimeQuantity#hashCode()} с разными мерами измерения.
	 */
	@Test
	public void testHashCodeDifferentMeasure()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(1, TimeMeasure.KILOSECOND);

		Integer expectedHashCode = timeQuantity1.hashCode();
		Integer actualHashCode = timeQuantity2.hashCode();

		assertNotEquals(expectedHashCode, actualHashCode);
	}

	/**
	 * Проверка метода {@link TimeQuantity#hashCode()} с разными величинами.
	 */
	@Test
	public void testHashCodeDifferentQuantity()
	{
		TimeQuantity timeQuantity1 = new TimeQuantity(1, TimeMeasure.SECOND);
		TimeQuantity timeQuantity2 = new TimeQuantity(2, TimeMeasure.SECOND);

		Integer expectedHashCode = timeQuantity1.hashCode();
		Integer actualHashCode = timeQuantity2.hashCode();

		assertNotEquals(expectedHashCode, actualHashCode);
	}
}