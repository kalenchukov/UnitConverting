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
import dev.kalenchukov.unit.converting.resources.TimeMeasure;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link AbstractQuantity}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractQuantityTest
{
	/**
	 * Проверка метода {@link AbstractQuantity#getQuantity()}.
	 */
	@Test
	public void getQuantity()
	{
		Quantitative<MassMeasure> quantity = new MassQuantity(1, MassMeasure.GRAM);

		BigDecimal actualQuantity = quantity.getQuantity();

		assertThat(actualQuantity).isEqualTo(new BigDecimal(1));
	}

	/**
	 * Проверка метода {@link AbstractQuantity#getMeasure()}.
	 */
	@Test
	public void getMeasure()
	{
		Quantitative<MassMeasure> quantity = new MassQuantity(1, MassMeasure.GRAM);

		Measurable actualMeasure = quantity.getMeasure();

		assertThat(actualMeasure).isEqualTo(MassMeasure.GRAM);
	}

	/**
	 * Проверка метода {@link AbstractQuantity#toString()}.
	 */
	@Test
	public void testToString()
	{
		Quantitative<MassMeasure> quantity = new MassQuantity(1, MassMeasure.GRAM);

		String actualString = quantity.toString();

		assertThat(actualString).isEqualTo("1 GRAM");
	}

	/**
	 * Класс проверки метода {@link AbstractQuantity#convert(Measurable)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Convert
	{
		/**
		 * Проверка метода {@link AbstractQuantity#convert(Measurable)}.
		 */
		@Test
		public void convert()
		{
			Quantitative<MassMeasure> quantity = new MassQuantity(1, MassMeasure.KILOGRAM);

			BigDecimal actualQuantity = quantity.convert(MassMeasure.GRAM);

			assertThat(actualQuantity).isEqualTo(new BigDecimal(1000));
		}

		/**
		 * Проверка метода {@link AbstractQuantity#convert(Measurable)} с {@code null}.
		 */
		@Test()
		public void convertZero()
		{
			Quantitative<MassMeasure> quantity = new MassQuantity(0, MassMeasure.GRAM);

			BigDecimal actualQuantity = quantity.convert(MassMeasure.KILOGRAM);

			assertThat(actualQuantity).isEqualTo(BigDecimal.ZERO);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractQuantity#compareTo(Quantitative)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class CompareTo
	{
		/**
		 * Проверка метода {@link AbstractQuantity#compareTo(Quantitative)} со
		 * сравнением равного значения.
		 */
		@Test
		public void compareTo()
		{
			MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.KILOGRAM);
			MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.KILOGRAM);

			int actualCompare = massQuantity1.compareTo(massQuantity2);

			assertThat(actualCompare).isEqualTo(0);
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
		 * сравнением меньшего значения с большим.
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

	/**
	 * Класс проверки метода {@link AbstractQuantity#equals(Object)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Equals
	{
		/**
		 * Проверка метода {@link AbstractQuantity#equals(Object)}.
		 */
		@Test
		public void testEquals()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(1, MassMeasure.GRAM);

			boolean actual = quantity1.equals(quantity2);

			assertThat(actual).isTrue();
		}

		/**
		 * Проверка метода {@link AbstractQuantity#equals(Object)} с {@code null}.
		 */
		@Test
		public void testEqualsNull()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = null;

			boolean actual = quantity1.equals(quantity2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractQuantity#equals(Object)} с разными классами.
		 */
		@Test
		public void testEqualsDifferentClass()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<TimeMeasure> quantity2 = new TimeQuantity(1, TimeMeasure.SECOND);

			boolean actual = quantity1.equals(quantity2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractQuantity#equals(Object)} с разными мерами измерения.
		 */
		@Test
		public void testEqualsDifferentMeasure()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(1, MassMeasure.KILOGRAM);

			boolean actual = quantity1.equals(quantity2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractQuantity#equals(Object)} с разными величинами.
		 */
		@Test
		public void testEqualsDifferentQuantity()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(2, MassMeasure.GRAM);

			boolean actual = quantity1.equals(quantity2);

			assertThat(actual).isFalse();
		}
	}

	/**
	 * Класс проверки метода {@link AbstractQuantity#hashCode()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class HashCode
	{
		/**
		 * Проверка метода {@link AbstractQuantity#hashCode()}.
		 */
		@Test
		public void testHashCode()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(1, MassMeasure.GRAM);

			int expectedHashCode = quantity1.hashCode();
			int actualHashCode = quantity2.hashCode();

			assertThat(actualHashCode).isEqualTo(expectedHashCode);
		}

		/**
		 * Проверка метода {@link AbstractQuantity#hashCode()} с разными мерами измерения.
		 */
		@Test
		public void testHashCodeDifferentMeasure()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(1, MassMeasure.KILOGRAM);

			int expectedHashCode = quantity1.hashCode();
			int actualHashCode = quantity2.hashCode();

			assertThat(actualHashCode).isNotEqualTo(expectedHashCode);
		}

		/**
		 * Проверка метода {@link AbstractQuantity#hashCode()} с разными величинами.
		 */
		@Test
		public void testHashCodeDifferentQuantity()
		{
			Quantitative<MassMeasure> quantity1 = new MassQuantity(1, MassMeasure.GRAM);
			Quantitative<MassMeasure> quantity2 = new MassQuantity(2, MassMeasure.GRAM);

			int expectedHashCode = quantity1.hashCode();
			int actualHashCode = quantity2.hashCode();

			assertThat(actualHashCode).isNotEqualTo(expectedHashCode);
		}
	}
}