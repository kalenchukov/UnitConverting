/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unitconverter;

import dev.kalenchukov.unitconverter.sources.MassMeasure;
import dev.kalenchukov.unitconverter.sources.Measurable;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Класс величины массы.
 *
 * @see AbstractQuantity
 */
public final class MassQuantity extends AbstractQuantity<MassQuantity, MassMeasure>
{
	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Byte quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Short quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Integer quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Long quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Float quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final Double quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final BigInteger quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * @see AbstractQuantity#AbstractQuantity(BigDecimal, Measurable)
	 */
	public MassQuantity(@NotNull final BigDecimal quantity, @NotNull final MassMeasure measure)
	{
		super(quantity, measure);
	}

	/**
	 * Сравнивает два объекта {@code Mass}.
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
	public static int compare(@NotNull final MassQuantity quantityX, @NotNull final MassQuantity quantityY)
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

		MassQuantity massQuantity = (MassQuantity) obj;

		if (!Objects.equals(this.getQuantity(), massQuantity.getQuantity())) {
			return false;
		}

		if (!Objects.equals(this.getMeasure(), massQuantity.getMeasure())) {
			return false;
		}

		return true;
	}

	@Override
	public String toString()
	{
		return "Mass {" +
			"quantity=" + this.getQuantity() + ", " +
			"measure=" + this.getMeasure() +
			"}";
	}
}
