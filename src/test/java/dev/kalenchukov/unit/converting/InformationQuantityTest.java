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
 * @author Aleksey Kalenchukov
 */
public class InformationQuantityTest
{
	/**
	 * Проверка создания объекта {@link InformationQuantity} с отрицательной величиной.
	 */
	@Test
	public void testNegativeQuality()
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
	public void testCompareMore()
	{
		int result = InformationQuantity.compare(
			new InformationQuantity(1, InformationMeasure.YOBIBIT),
			new InformationQuantity(1, InformationMeasure.ZEBIBIT)
		);

		assertEquals(1, result);
	}

	/**
	 * Проверка метода {@link InformationQuantity#compare(InformationQuantity, InformationQuantity)} со
	 * сравнением равных значений.
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
	 * Проверка метода {@link InformationQuantity#compare(InformationQuantity, InformationQuantity)} со
	 * сравнением меньшего значения с большим.
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
	 * Проверка метода {@link InformationQuantity#equals(Object)}.
	 */
	@Test
	public void testEquals()
	{
		assertEquals(
			new InformationQuantity(1, InformationMeasure.BYTE),
			new InformationQuantity(1, InformationMeasure.BYTE)
		);
	}

	/**
	 * Проверка метода {@link InformationQuantity#equals(Object)} с разными объектами.
	 */
	@Test
	public void testEqualsNotCorrect()
	{
		// Разница в мере измерения
		assertNotEquals(
			new InformationQuantity(1, InformationMeasure.BYTE),
			new InformationQuantity(1, InformationMeasure.KILOBYTE)
		);

		// Разница в величине
		assertNotEquals(
			new InformationQuantity(1, InformationMeasure.BYTE),
			new InformationQuantity(2, InformationMeasure.BYTE)
		);

		// Разница в мере измерения и величине
		assertNotEquals(
			new InformationQuantity(1, InformationMeasure.BYTE),
			new InformationQuantity(3, InformationMeasure.KILOBYTE)
		);
	}
}