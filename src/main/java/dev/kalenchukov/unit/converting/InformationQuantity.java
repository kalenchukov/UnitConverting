/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unit.converting;

import dev.kalenchukov.unit.converting.sources.Measurable;
import dev.kalenchukov.unit.converting.sources.InformationMeasure;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Класс величины информации.
 *
 * @see AbstractQuantity
 */
public final class InformationQuantity extends AbstractQuantity<InformationQuantity, InformationMeasure>
{
	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Byte quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Short quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Integer quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Long quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Float quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final Double quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final BigInteger quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public InformationQuantity(@NotNull final BigDecimal quantity, @NotNull final InformationMeasure measure)
	{
		super(Objects.requireNonNull(quantity), Objects.requireNonNull(measure));
	}

	/**
	 * Сравнивает два объекта {@code Information}.
	 *
	 * @param quantityX Первый объект для сравнения.
	 * @param quantityY Второй объект для сравнения.
	 * @return
	 * <ul>
	 *     <li><b>-1</b> - если объект {@code quantityX} меньше {@code quantityY}.</li>
	 *     <li><b>0</b> - если объект {@code quantityX} равен {@code quantityY}.</li>
	 *     <li><b>1</b> если объект {@code quantityX} больше {@code quantityY}.</li>
	 * </ul>
	 */
	public static int compare(@NotNull final InformationQuantity quantityX, @NotNull final InformationQuantity quantityY)
	{
		Objects.requireNonNull(quantityX);
		Objects.requireNonNull(quantityY);

		return quantityX.compareTo(quantityY);
	}

	@Override
	public int hashCode()
	{
		int result = 0;

		result = 31 * result + this.getQuantity().hashCode();
		result = 31 * result + this.getMeasure().hashCode();

		return result;
	}

	@Override
	public boolean equals(final Object obj)
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

		InformationQuantity informationQuantity = (InformationQuantity) obj;

		if (!Objects.equals(this.getQuantity(), informationQuantity.getQuantity())) {
			return false;
		}

		if (!Objects.equals(this.getMeasure(), informationQuantity.getMeasure())) {
			return false;
		}

		return true;
	}

	@NotNull
	@Override
	public String toString()
	{
		return "InformationQuantity{" + "quantity=" + quantity + ", measure=" + measure + '}';
	}
}
