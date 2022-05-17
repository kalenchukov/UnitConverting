/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unitconverter;

import dev.kalenchukov.unitconverter.sources.Measurable;
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
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Byte quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Short quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Integer quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Long quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Float quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final Double quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public AbstractQuantity(@NotNull final BigInteger quantity, @NotNull final M measure)
	{
		this(new BigDecimal(quantity), measure);
	}

	/**
	 * Конструктор для {@code AbstractQuantity}.
	 *
	 * @param quantity Величина.
	 * @param measure Мера измерения величины.
	 * @throws IllegalArgumentException Если величина аргумента {@code quantity} меньше 0.
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
	 * @see Quantitative#getQuantity()
	 */
	@NotNull
	@Override
	public BigDecimal getQuantity()
	{
		return this.quantity;
	}

	/**
	 * @see Quantitative#getMeasure()
	 */
	@NotNull
	@Override
	public M getMeasure()
	{
		return this.measure;
	}

	/**
	 * @see Quantitative#convert(Measurable)
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
	 * @param anotherQuantity Другой объект для сравнения.
	 * @return
	 * <ul>
	 *     <li><b>-1</b> - если данный объект меньше {@code anotherQuantity}.</li>
	 *     <li><b>0</b> - если данный объект равен {@code anotherQuantity}.</li>
	 *     <li><b>1</b> если данный объект больше {@code anotherQuantity}.</li>
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
