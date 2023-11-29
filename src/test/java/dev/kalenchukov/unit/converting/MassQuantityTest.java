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

import dev.kalenchukov.unit.converting.types.MassMeasure;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link MassQuantity}.
 *
 * @author Алексей Каленчуков
 */
public class MassQuantityTest
{
	/**
	 * Класс проверки статических методов.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Static
	{
		/**
		 * Класс проверки метода {@link MassQuantity#compare(MassQuantity, MassQuantity)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class Compare
		{
			/**
			 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
			 * сравнением большего значения с меньшим.
			 */
			@Test
			public void compareMore()
			{
				MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.YOTTAGRAM);
				MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.ZETTAGRAM);

				int actualCompare = MassQuantity.compare(massQuantity1, massQuantity2);

				assertThat(actualCompare).isEqualTo(1);
			}

			/**
			 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
			 * сравнением равных значений.
			 */
			@Test
			public void compareEqually()
			{
				MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.KILOGRAM);
				MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.KILOGRAM);

				int actualCompare = MassQuantity.compare(massQuantity1, massQuantity2);

				assertThat(actualCompare).isEqualTo(0);
			}

			/**
			 * Проверка метода {@link MassQuantity#compare(MassQuantity, MassQuantity)} со
			 * сравнением меньшего значения с большим.
			 */
			@Test
			public void compareLess()
			{
				MassQuantity massQuantity1 = new MassQuantity(1, MassMeasure.ZETTAGRAM);
				MassQuantity massQuantity2 = new MassQuantity(1, MassMeasure.YOTTAGRAM);

				int actualCompare = MassQuantity.compare(massQuantity1, massQuantity2);

				assertThat(actualCompare).isEqualTo(-1);
			}
		}
	}
}