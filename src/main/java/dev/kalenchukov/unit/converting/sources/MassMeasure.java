/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unit.converting.sources;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Objects;

/**
 * Перечисление мер измерения массы.
 */
public enum MassMeasure implements Measurable
{
	/**
	 * Йоктограмм.
	 * <p>10<sup>-24</sup> грамма = 0.000 000 000 000 000 000 000 001.</p>
	 *
	 * Наименьшая мера измерения массы.
	 */
	YOCTOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-24, new MathContext(32))
	),

	/**
	 * Зептограмм.
	 * <p>10<sup>-21</sup> грамма = 0.000 000 000 000 000 000 001.</p>
	 */
	ZEPTOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-21, new MathContext(32))
	),

	/**
	 * Аттограмм.
	 * <p>10<sup>-18</sup> грамма = 0.000 000 000 000 000 001.</p>
	 */
	ATTOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-18, new MathContext(32))
	),

	/**
	 * Фемтограмм.
	 * <p>10<sup>-15</sup> грамма = 0.000 000 000 000 001.</p>
	 */
	FEMTOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-15, new MathContext(32))
	),

	/**
	 * Пикограмм.
	 * <p>10<sup>-12</sup> грамма = 0.000 000 000 001.</p>
	 */
	PICOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-12, new MathContext(32))
	),

	/**
	 * Нанограмм.
	 * <p>10<sup>-9</sup> грамма = 0.000 000 001.</p>
	 */
	NANOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-9, new MathContext(32))
	),

	/**
	 * Микрограмм.
	 * <p>10<sup>-6</sup> грамма = 0.000 001.</p>
	 */
	MICROGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-6, new MathContext(32))
	),

	/**
	 * Миллиграмм.
	 * <p>10<sup>-3</sup> грамма = 0.001.</p>
	 */
	MILLIGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-3, new MathContext(32))
	),

	/**
	 * Сантиграмм.
	 * <p>10<sup>-2</sup> грамма = 0.01.</p>
	 */
	CENTIGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-2, new MathContext(32))
	),

	/**
	 * Дециграмм.
	 * <p>10<sup>-1</sup> грамма = 0.1.</p>
	 */
	DECIGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(-1, new MathContext(32))
	),

	/**
	 * Грамм.
	 * <p>10<sup>-0</sup> грамма = 1.</p>
	 */
	GRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(0)
	),

	/**
	 * Декаграмм.
	 * <p>10<sup>1</sup> грамма = 10.</p>
	 */
	DECAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(1)
	),

	/**
	 * Гектограмм.
	 * <p>10<sup>2</sup> грамма = 100.</p>
	 */
	HECTOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(2)
	),

	/**
	 * Килограмм.
	 * <p>10<sup>3</sup> грамма = 1 000.</p>
	 */
	KILOGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(3)
	),

	/**
	 * Мегаграмм.
	 * <p>10<sup>6</sup> грамма = 1 000 000.</p>
	 */
	MEGAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(6)
	),

	/**
	 * Гигаграмм.
	 * <p>10<sup>9</sup> грамма = 1 000 000 000.</p>
	 */
	GIGAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(9)
	),

	/**
	 * Тераграмм.
	 * <p>10<sup>12</sup> грамма = 1 000 000 000 000.</p>
	 */
	TERAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(12)
	),

	/**
	 * Петаграмм.
	 * <p>10<sup>15</sup> грамма = 1 000 000 000 000 000.</p>
	 */
	PETAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(15)
	),

	/**
	 * Эксаграмм.
	 * <p>10<sup>18</sup> грамма = 1 000 000 000 000 000 000.</p>
	 */
	EXAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(18)
	),

	/**
	 * Зеттаграмм.
	 * <p>10<sup>21</sup> грамма = 1 000 000 000 000 000 000 000.</p>
	 */
	ZETTAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(21)
	),

	/**
	 * Йоттаграмм.
	 * <p>10<sup>24</sup> грамма = 1 000 000 000 000 000 000 000 000.</p>
	 */
	YOTTAGRAM(
		List.of(Standard.SI),
		new BigDecimal(10).pow(24)
	);

	/**
	 * Список стандартов меры измерения.
	 */
	@NotNull
	private final List<@NotNull Standard> standard;

	/**
	 * Количество минимальных единиц меры.
	 */
	@NotNull
	private final BigDecimal countMinUnit;

	/**
	 * Конструктор для {@code MassMeasure}.
	 *
	 * @param standard Список стандартов меры измерения.
	 * @param countMinUnit Количество минимальных единиц меры.
	 */
	MassMeasure(@NotNull final List<@NotNull Standard> standard, @NotNull final BigDecimal countMinUnit)
	{
		Objects.requireNonNull(standard);
		Objects.requireNonNull(countMinUnit);

		this.standard = standard;
		this.countMinUnit = countMinUnit;
	}

	/**
	 * @see Measurable#getStandard()
	 */
	@NotNull
	@Override
	public List<@NotNull Standard> getStandard()
	{
		return this.standard;
	}

	/**
	 * @see Measurable#getCountMinUnit()
	 */
	@NotNull
	@Override
	public BigDecimal getCountMinUnit()
	{
		return this.countMinUnit;
	}

	/**
	 * Возвращает наименьшую меру измерения.
	 *
	 * @return Наименьшая мера измерения.
	 */
	@NotNull
	public static MassMeasure getMin()
	{
		MassMeasure resultMeasure = MassMeasure.GRAM;

		for (MassMeasure measure : MassMeasure.values())
		{
			if (measure.getCountMinUnit().compareTo(resultMeasure.getCountMinUnit()) < 0) {
				resultMeasure = measure;
			}
		}

		return resultMeasure;
	}

	/**
	 * Возвращает наибольшую меру измерения.
	 *
	 * @return Наибольшая мера измерения.
	 */
	@NotNull
	public static MassMeasure getMax()
	{
		MassMeasure resultMeasure = MassMeasure.GRAM;

		for (MassMeasure measure : MassMeasure.values())
		{
			if (measure.getCountMinUnit().compareTo(resultMeasure.getCountMinUnit()) > 0) {
				resultMeasure = measure;
			}
		}

		return resultMeasure;
	}

	/**
	 * Возвращает наименьшую меру измерения по стандарту.
	 *
	 * @param standard Стандарт меры измерения.
	 * @return Наименьшая мера измерения, или {@code null} если меры измерения нет.
	 */
	@Nullable
	public static MassMeasure getMin(@NotNull final Standard standard)
	{
		Objects.requireNonNull(standard);

		MassMeasure resultMeasure = null;

		for (MassMeasure measure : MassMeasure.values())
		{
			if (measure.getStandard().contains(standard))
			{
				if (resultMeasure == null) {
					resultMeasure = measure;
				}

				if (measure.getCountMinUnit().compareTo(resultMeasure.getCountMinUnit()) < 0) {
					resultMeasure = measure;
				}
			}
		}

		return resultMeasure;
	}

	/**
	 * Возвращает наибольшую меру измерения по стандарту.
	 *
	 * @param standard Стандарт меры измерения.
	 * @return Наибольшая мера измерения, или {@code null} если меры измерения нет.
	 */
	@Nullable
	public static MassMeasure getMax(@NotNull final Standard standard)
	{
		Objects.requireNonNull(standard);

		MassMeasure resultMeasure = null;

		for (MassMeasure measure : MassMeasure.values())
		{
			if (measure.getStandard().contains(standard))
			{
				if (resultMeasure == null) {
					resultMeasure = measure;
				}

				if (measure.getCountMinUnit().compareTo(resultMeasure.getCountMinUnit()) > 0) {
					resultMeasure = measure;
				}
			}
		}

		return resultMeasure;
	}
}
