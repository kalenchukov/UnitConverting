/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unit.converting.sources;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Перечисление мер измерения информации.
 */
public enum InformationMeasure implements Measurable
{
	/**
	 * Бит.
	 * <p>2<sup>0</sup> бит = 1.</p>
	 *
	 * Наименьшая мера измерения информации.
	 */
	BIT(
		List.of(Standard.IEC, Standard.SI),
		new BigDecimal(1)
	),

	/**
	 * Кибибит.
	 * <p>2<sup>10</sup> бит = 1 024.</p>
	 */
	KIBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(10)
	),

	/**
	 * Мебибит.
	 * <p>2<sup>20</sup> бит = 1 048 576.</p>
	 */
	MEBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(20)
	),

	/**
	 * Гибибит.
	 * <p>2<sup>30</sup> бит = 1 073 741 824.</p>
	 */
	GIBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(30)
	),

	/**
	 * Тебибит.
	 * <p>2<sup>40</sup> бит = 1 099 511 627 776.</p>
	 */
	TEBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(40)
	),

	/**
	 * Пебибит.
	 * <p>2<sup>50</sup> бит = 1 125 899 906 842 624.</p>
	 */
	PEBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(50)
	),

	/**
	 * Эксбибит.
	 * <p>2<sup>60</sup> бит = 1 152 921 504 606 846 976.</p>
	 */
	EXBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(60)
	),

	/**
	 * Зебибит.
	 * <p>2<sup>70</sup> бит = 1 180 591 620 717 411 303 424.</p>
	 */
	ZEBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(70)
	),

	/**
	 * Йобибит.
	 * <p>2<sup>80</sup> бит = 1 208 925 819 614 629 174 706 176.</p>
	 */
	YOBIBIT(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(80)
	),

	/**
	 * Килобит.
	 * <p>10<sup>3</sup> бит = 1 000.</p>
	 */
	KILOBIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(3)
	),

	/**
	 * Мегабит.
	 * <p>10<sup>6</sup> бит = 1 000 000.</p>
	 */
	MEGABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(6)
	),

	/**
	 * Гигабит.
	 * <p>10<sup>9</sup> бит = 1 000 000 000.</p>
	 */
	GIGABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(9)
	),

	/**
	 * Терабит.
	 * <p>10<sup>12</sup> бит = 1 000 000 000 000.</p>
	 */
	TERABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(12)
	),

	/**
	 * Петабит.
	 * <p>10<sup>15</sup> бит = 1 000 000 000 000 000.</p>
	 */
	PETABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(15)
	),

	/**
	 * Эксабит.
	 * <p>10<sup>18</sup> бит = 1 000 000 000 000 000 000.</p>
	 */
	EXABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(18)
	),

	/**
	 * Зеттабит.
	 * <p>10<sup>21</sup> бит = 1 000 000 000 000 000 000 000.</p>
	 */
	ZETTABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(21)
	),

	/**
	 * Йоттабит.
	 * <p>10<sup>24</sup> бит = 1 000 000 000 000 000 000 000 000.</p>
	 */
	YOTTABIT(
		List.of(Standard.SI),
		new BigDecimal(10).pow(24)
	),

	/**
	 * Байт.
	 * <p>2<sup>0</sup> байт = 1.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	BYTE(
		List.of(Standard.IEC, Standard.SI),
		new BigDecimal(1).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Кибибайт.
	 * <p>2<sup>10</sup> байт = 1 024.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	KIBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(10).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Мебибайт.
	 * <p>2<sup>20</sup> байт = 1 048 576.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	MEBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(20).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Гибибайт.
	 * <p>2<sup>30</sup> байт = 1 073 741 824.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	GIBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(30).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Тебибайт.
	 * <p>2<sup>40</sup> байт = 1 099 511 627 776.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	TEBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(40).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Пебибайт.
	 * <p>2<sup>50</sup> байт = 1 125 899 906 842 624.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	PEBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(50).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Эксбибайт.
	 * <p>2<sup>60</sup> байт = 1 152 921 504 606 846 976.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	EXBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(60).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Зебибайт.
	 * <p>2<sup>70</sup> байт = 1 180 591 620 717 411 303 424.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	ZEBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(70).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Йобибайт.
	 * <p>2<sup>80</sup> байт = 1 208 925 819 614 629 174 706 176.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	YOBIBYTE(
		List.of(Standard.IEC),
		new BigDecimal(2).pow(80).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Килобайт.
	 * <p>10<sup>3</sup> байт = 1 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	KILOBYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(3).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Мегабайт.
	 * <p>10<sup>6</sup> байт = 1 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	MEGABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(6).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Гигабайт.
	 * <p>10<sup>9</sup> байт = 1 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	GIGABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(9).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Терабайт.
	 * <p>10<sup>12</sup> байт = 1 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	TERABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(12).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Петабайт.
	 * <p>10<sup>15</sup> байт = 1 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	PETABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(15).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Эксабайт.
	 * <p>10<sup>18</sup> байт = 1 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	EXABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(18).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Зеттабайт.
	 * <p>10<sup>21</sup> байт = 1 000 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	ZETTABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(21).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Йоттабайт.
	 * <p>10<sup>24</sup> байт = 1 000 000 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину - {@link InformationMeasure#BIT}.
	 */
	YOTTABYTE(
		List.of(Standard.SI),
		new BigDecimal(10).pow(24).multiply(BigDecimal.valueOf(8))
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
	 * Конструктор для {@code InformationMeasure}.
	 *
	 * @param standard Список стандартов меры измерения.
	 * @param countMinUnit Количество минимальных единиц меры.
	 */
	InformationMeasure(@NotNull final List<@NotNull Standard> standard, @NotNull final BigDecimal countMinUnit)
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
	public static InformationMeasure getMin()
	{
		InformationMeasure resultMeasure = InformationMeasure.BYTE;

		for (InformationMeasure measure : InformationMeasure.values())
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
	public static InformationMeasure getMax()
	{
		InformationMeasure resultMeasure = InformationMeasure.BYTE;

		for (InformationMeasure measure : InformationMeasure.values())
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
	public static InformationMeasure getMin(@NotNull final Standard standard)
	{
		Objects.requireNonNull(standard);

		InformationMeasure resultMeasure = null;

		for (InformationMeasure measure : InformationMeasure.values())
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
	public static InformationMeasure getMax(@NotNull final Standard standard)
	{
		Objects.requireNonNull(standard);

		InformationMeasure resultMeasure = null;

		for (InformationMeasure measure : InformationMeasure.values())
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
