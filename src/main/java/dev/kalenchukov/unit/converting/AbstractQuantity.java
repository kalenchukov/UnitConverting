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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

/**
 * Класс абстрактной величины.
 *
 * @param <Q> Тип объекта величины.
 * @param <M> Тип объекта меры измерения величины.
 */
public abstract class AbstractQuantity<Q extends Quantitative<M>, M extends Measurable>
	implements Comparable<Q>, Quantitative<M>
{
	/**
	 * Величина.
	 */
	@NotNull
	protected final BigDecimal quantity;

	/**
	 * Мера измерения величины.
	 */
	@NotNull
	protected final M measure;

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Byte quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Short quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Integer quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Long quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Float quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final Double quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final BigInteger quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public AbstractQuantity(@NotNull final BigDecimal quantity, @NotNull final M measure)
	{
		Objects.requireNonNull(quantity);
		Objects.requireNonNull(measure);

		if (quantity.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Величина не может быть меньше 0.");
		}

		this.quantity = quantity;
		this.measure = measure;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public BigDecimal getQuantity()
	{
		return this.quantity;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public M getMeasure()
	{
		return this.measure;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param measure {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public BigDecimal convert(@NotNull final M measure)
	{
		Objects.requireNonNull(measure);

		return this.getQuantity()
				   .multiply(this.getMeasure().getCountMinUnit())
				   .divide(measure.getCountMinUnit(), new MathContext(32));
	}

	/**
	 * Сравнивает данный объект с другим объектом {@code AbstractQuantity}.
	 *
	 * @param anotherQuantity другой объект для сравнения.
	 * @return
	 * <ul>
	 *     <li><b>-1</b> - если данный объект меньше {@code anotherQuantity}.</li>
	 *     <li><b>0</b> - если данный объект равен {@code anotherQuantity}.</li>
	 *     <li><b>1</b> - если данный объект больше {@code anotherQuantity}.</li>
	 * </ul>
	 */
	@Override
	public int compareTo(@NotNull final Q anotherQuantity)
	{
		Objects.requireNonNull(anotherQuantity);

		BigDecimal quantityX = this.getQuantity()
								   .multiply(this.getMeasure().getCountMinUnit());

		BigDecimal quantityY = anotherQuantity.getQuantity()
											  .multiply(anotherQuantity.getMeasure().getCountMinUnit());

		return quantityX.compareTo(quantityY);
	}
}
