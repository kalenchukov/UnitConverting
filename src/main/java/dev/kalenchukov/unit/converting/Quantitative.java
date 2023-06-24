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

import dev.kalenchukov.unit.converting.resources.Measurable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;

/**
 * Интерфейс для реализации класса величин.
 *
 * @param <M> Тип объекта меры измерения величины.
 * @author Алексей Каленчуков
 */
public interface Quantitative<M extends Measurable>
{
	/**
	 * Возвращает величину.
	 *
	 * @return величину.
	 */
	@NotNull
	BigDecimal getQuantity();

	/**
	 * Возвращает меру измерения величины.
	 *
	 * @return мера измерения величины.
	 */
	@NotNull
	M getMeasure();

	/**
	 * Конвертирует величину в указанную меру измерения.
	 *
	 * @param measure мера измерения величины.
	 * @return величина.
	 */
	@NotNull
	BigDecimal convert(@NotNull M measure);

	/**
	 * Проверяет равенство объектов.
	 *
	 * @param obj сравниваемый объект.
	 * @return {@code true}, если данный объект равен {@code obj}, иначе {@code false}.
	 * @see Object#equals(Object)
	 */
	boolean equals(@Nullable Object obj);

	/**
	 * Возвращает значение объекта в виде числа.
	 *
	 * @return число.
	 * @see Object#hashCode()
	 */
	int hashCode();

	/**
	 * Возвращает значение объекта в виде строки.
	 *
	 * @return строку.
	 * @see Object#toString()
	 */
	@NotNull
	String toString();
}
