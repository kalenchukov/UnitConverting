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
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Класс величины времени.
 *
 * @author Алексей Каленчуков
 */
public final class TimeQuantity extends AbstractQuantity<TimeQuantity, TimeMeasure>
{
	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final byte quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final short quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final int quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final long quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final float quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(final double quantity, @NotNull final TimeMeasure measure)
	{
		super(quantity, Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code quantity} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final BigInteger quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws NullPointerException если в качестве {@code quantity} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code measure} передан {@code null}.
	 * @throws IllegalArgumentException если {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final BigDecimal quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Сравнивает объекты.
	 *
	 * @param quantityX первый объект для сравнения.
	 * @param quantityY второй объект для сравнения.
	 * @return
	 * <ul>
	 *     <li><b>-1</b> - если {@code quantityX} меньше {@code quantityY}.</li>
	 *     <li><b>0</b> - если {@code quantityX} равен {@code quantityY}.</li>
	 *     <li><b>1</b> - если {@code quantityX} больше {@code quantityY}.</li>
	 * </ul>
	 * @throws NullPointerException если в качестве {@code quantityX} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code quantityY} передан {@code null}.
	 */
	public static int compare(@NotNull final TimeQuantity quantityX,
							  @NotNull final TimeQuantity quantityY)
	{
		Objects.requireNonNull(quantityX);
		Objects.requireNonNull(quantityY);

		return quantityX.compareTo(quantityY);
	}
}
