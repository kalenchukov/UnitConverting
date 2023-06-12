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

import dev.kalenchukov.unit.converting.resources.InformationMeasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link InformationQuantity}.
 *
 * @author Алексей Каленчуков
 */
public class InformationQuantityTest
{
	/**
	 * Проверка создания объекта {@link InformationQuantity} с отрицательной величиной.
	 */
	@Test
	public void negativeQuality()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new InformationQuantity(-1, InformationMeasure.BYTE);
		});
	}

	/**
	 * Проверка метода {@link InformationQuantity#compare(InformationQuantity, InformationQuantity)} со
	 * сравнением большего значения с меньшим.
	 */
	@Test
	public void compareMore()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.YOBIBIT);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.ZEBIBIT);

		Integer actualCompare = InformationQuantity.compare(informationQuantity1, informationQuantity2);

		assertEquals(1, actualCompare);
	}

	/**
	 * Проверка метода {@link InformationQuantity#compare(InformationQuantity, InformationQuantity)} со
	 * сравнением равных значений.
	 */
	@Test
	public void compareEqually()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.MEBIBIT);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.MEBIBIT);

		Integer actualCompare = InformationQuantity.compare(informationQuantity1, informationQuantity2);

		assertEquals(0, actualCompare);
	}

	/**
	 * Проверка метода {@link InformationQuantity#compare(InformationQuantity, InformationQuantity)} со
	 * сравнением меньшего значения с большим.
	 */
	@Test
	public void compareLess()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.ZEBIBIT);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.YOBIBIT);

		Integer actualCompare = InformationQuantity.compare(informationQuantity1, informationQuantity2);

		assertEquals(-1, actualCompare);
	}

	/**
	 * Проверка метода {@link InformationQuantity#equals(Object)}.
	 */
	@Test
	public void testEquals()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.BYTE);

		boolean actual = informationQuantity1.equals(informationQuantity2);

		assertTrue(actual);
	}

	/**
	 * Проверка метода {@link InformationQuantity#equals(Object)} с разными мерами измерения.
	 */
	@Test
	public void testEqualsDifferentMeasure()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.KILOBYTE);

		boolean actual = informationQuantity1.equals(informationQuantity2);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link InformationQuantity#equals(Object)} с разными величинами.
	 */
	@Test
	public void testEqualsDifferentQuantity()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(2, InformationMeasure.BYTE);

		boolean actual = informationQuantity1.equals(informationQuantity2);

		assertFalse(actual);
	}

	/**
	 * Проверка метода {@link InformationQuantity#hashCode()}.
	 */
	@Test
	public void testHashCode()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.BYTE);

		Integer expectedHashCode = informationQuantity1.hashCode();
		Integer actualHashCode = informationQuantity2.hashCode();

		assertEquals(expectedHashCode, actualHashCode);
	}

	/**
	 * Проверка метода {@link InformationQuantity#hashCode()} с разными мерами измерения.
	 */
	@Test
	public void testHashCodeDifferentMeasure()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(1, InformationMeasure.KILOBYTE);

		Integer expectedHashCode = informationQuantity1.hashCode();
		Integer actualHashCode = informationQuantity2.hashCode();

		assertNotEquals(expectedHashCode, actualHashCode);
	}

	/**
	 * Проверка метода {@link InformationQuantity#hashCode()} с разными величинами.
	 */
	@Test
	public void testHashCodeDifferentQuantity()
	{
		InformationQuantity informationQuantity1 = new InformationQuantity(1, InformationMeasure.BYTE);
		InformationQuantity informationQuantity2 = new InformationQuantity(2, InformationMeasure.BYTE);

		Integer expectedHashCode = informationQuantity1.hashCode();
		Integer actualHashCode = informationQuantity2.hashCode();

		assertNotEquals(expectedHashCode, actualHashCode);
	}
}