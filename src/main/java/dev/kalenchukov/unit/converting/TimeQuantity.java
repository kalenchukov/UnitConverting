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
import org.jetbrains.annotations.Nullable;

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
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Byte quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Short quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Integer quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Long quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Float quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final Double quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code TimeQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины времени.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
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
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public TimeQuantity(@NotNull final BigDecimal quantity, @NotNull final TimeMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Сравнивает два объекта {@code Time}.
	 *
	 * @param quantityX первый объект для сравнения.
	 * @param quantityY второй объект для сравнения.
	 * @return
	 * <ul>
	 *     <li><b>-1</b> - если объект {@code quantityX} меньше {@code quantityY}.</li>
	 *     <li><b>0</b> - если объект {@code quantityX} равен {@code quantityY}.</li>
	 *     <li><b>1</b> - если объект {@code quantityX} больше {@code quantityY}.</li>
	 * </ul>
	 */
	public static int compare(@NotNull final TimeQuantity quantityX, @NotNull final TimeQuantity quantityY)
	{
		Objects.requireNonNull(quantityX);
		Objects.requireNonNull(quantityY);

		return quantityX.compareTo(quantityY);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		int result = 0;

		result = 31 * result + this.getQuantity().hashCode();
		result = 31 * result + this.getMeasure().hashCode();

		return result;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param obj {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean equals(@Nullable final Object obj)
	{
		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		TimeQuantity quantity = (TimeQuantity) obj;

		if (!Objects.equals(this.getQuantity(), quantity.getQuantity())) {
			return false;
		}

		if (!Objects.equals(this.getMeasure(), quantity.getMeasure())) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public String toString()
	{
		return "TimeQuantity{" + "quantity=" + this.getQuantity() + ", measure=" + this.getMeasure() + '}';
	}
}
