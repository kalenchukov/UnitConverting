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

package dev.kalenchukov.unit.converting.types;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки констант и методов перечисления {@link TimeMeasure}.
 *
 * @author Алексей Каленчуков
 */
public class TimeMeasureTest
{
	/**
	 * Проверка метода {@link TimeMeasure#getStandard()}.
	 */
	@Test
	public void getStandard()
	{
		Measurable timeMeasure = TimeMeasure.SECOND;
		Set<Standard> expectedSet = Set.of(Standard.SI);

		Set<Standard> actualSet = timeMeasure.getStandard();

		assertThat(actualSet).containsExactlyElementsOf(expectedSet);
	}

	/**
	 * Проверка метода {@link TimeMeasure#getCountMinUnit()}.
	 */
	@Test
	public void getCountMinUnit()
	{
		Measurable timeMeasure = TimeMeasure.KILOSECOND;

		BigDecimal actualCountMinUnit = timeMeasure.getCountMinUnit();

		assertThat(actualCountMinUnit).isEqualTo(BigDecimal.valueOf(1000));
	}
}