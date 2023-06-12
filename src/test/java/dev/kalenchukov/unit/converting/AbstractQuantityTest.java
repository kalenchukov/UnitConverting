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

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractQuantityTest
{
	/**
	 * Проверка метода {@link AbstractQuantity#getQuantity()}.
	 */
	@Test
	public void getQuantity()
	{
		MassQuantity massQuantity = new MassQuantity(1, MassMeasure.GRAM);

		BigDecimal actualQuantity = massQuantity.getQuantity();

		assertThat(actualQuantity).isEqualTo(new BigDecimal(1));
	}

	/**
	 * Проверка метода {@link AbstractQuantity#getMeasure()}.
	 */
	@Test
	public void getMeasure()
	{
		MassQuantity massQuantity = new MassQuantity(1, MassMeasure.GRAM);

		MassMeasure actualMeasure = massQuantity.getMeasure();

		assertThat(actualMeasure).isEqualTo(MassMeasure.GRAM);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#convert(Measurable)}.
	 */
	@Test
	public void convert()
	{
		MassQuantity massQuantity = new MassQuantity(1, MassMeasure.KILOGRAM);

		BigDecimal actualQuantity = massQuantity.convert(MassMeasure.GRAM);

		assertThat(actualQuantity).isEqualTo(new BigDecimal(1000));
	}

	/**
	 * Проверка метода {@link AbstractQuantity#convert(Measurable)} с нулевым значением.
	 */
	@Test()
	public void convertZero()
	{
		MassQuantity massQuantity = new MassQuantity(0, MassMeasure.GRAM);

		BigDecimal actualQuantity = massQuantity.convert(MassMeasure.KILOGRAM);

		assertThat(actualQuantity).isEqualTo(BigDecimal.ZERO);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением большего значения.
	 */
	@Test
	public void compareToMore()
	{
		MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.YOTTAGRAM);
		MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.ZETTAGRAM);

		int actualCompare = massQuantity1.compareTo(massQuantity2);

		assertThat(actualCompare).isEqualTo(1);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением равного значения.
	 */
	@Test
	public void compareToEqually()
	{
		MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.KILOGRAM);
		MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.KILOGRAM);

		int actualCompare = massQuantity1.compareTo(massQuantity2);

		assertThat(actualCompare).isEqualTo(0);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
	 * сравнением меньшего значения.
	 */
	@Test
	public void compareToLess()
	{
		MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.ZETTAGRAM);
		MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.YOTTAGRAM);

		int actualCompare = massQuantity1.compareTo(massQuantity2);

		assertThat(actualCompare).isEqualTo(-1);
	}
}