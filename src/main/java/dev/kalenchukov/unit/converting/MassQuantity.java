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

import dev.kalenchukov.unit.converting.resources.MassMeasure;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Класс величины массы.
 *
 * @author Алексей Каленчуков
 */
public final class MassQuantity extends AbstractQuantity<MassQuantity, MassMeasure>
{
	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Byte quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Short quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Integer quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Long quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Float quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final Double quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final BigInteger quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Конструктор для {@code MassQuantity}.
	 *
	 * @param quantity величина.
	 * @param measure мера измерения величины массы.
	 * @throws IllegalArgumentException если величина аргумента {@code quantity} меньше 0.
	 */
	public MassQuantity(@NotNull final BigDecimal quantity, @NotNull final MassMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Сравнивает два объекта {@code Mass}.
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
	public static int compare(@NotNull final MassQuantity quantityX, @NotNull final MassQuantity quantityY)
	{
		Objects.requireNonNull(quantityX);
		Objects.requireNonNull(quantityY);

		return quantityX.compareTo(quantityY);
	}
}
