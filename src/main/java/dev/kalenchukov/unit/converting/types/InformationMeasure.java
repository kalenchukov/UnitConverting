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

package dev.kalenchukov.unit.converting.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.math.BigDecimal;
import java.util.Set;
import java.util.Objects;

/**
 * Перечисление мер измерения информации.
 *
 * @author Алексей Каленчуков
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
		Set.of(Standard.IEC, Standard.SI),
		new BigDecimal(1)
	),

	/**
	 * Кибибит.
	 * <p>2<sup>10</sup> бит = 1 024.</p>
	 */
	KIBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(10)
	),

	/**
	 * Мебибит.
	 * <p>2<sup>20</sup> бит = 1 048 576.</p>
	 */
	MEBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(20)
	),

	/**
	 * Гибибит.
	 * <p>2<sup>30</sup> бит = 1 073 741 824.</p>
	 */
	GIBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(30)
	),

	/**
	 * Тебибит.
	 * <p>2<sup>40</sup> бит = 1 099 511 627 776.</p>
	 */
	TEBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(40)
	),

	/**
	 * Пебибит.
	 * <p>2<sup>50</sup> бит = 1 125 899 906 842 624.</p>
	 */
	PEBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(50)
	),

	/**
	 * Эксбибит.
	 * <p>2<sup>60</sup> бит = 1 152 921 504 606 846 976.</p>
	 */
	EXBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(60)
	),

	/**
	 * Зебибит.
	 * <p>2<sup>70</sup> бит = 1 180 591 620 717 411 303 424.</p>
	 */
	ZEBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(70)
	),

	/**
	 * Йобибит.
	 * <p>2<sup>80</sup> бит = 1 208 925 819 614 629 174 706 176.</p>
	 */
	YOBIBIT(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(80)
	),

	/**
	 * Килобит.
	 * <p>10<sup>3</sup> бит = 1 000.</p>
	 */
	KILOBIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(3)
	),

	/**
	 * Мегабит.
	 * <p>10<sup>6</sup> бит = 1 000 000.</p>
	 */
	MEGABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(6)
	),

	/**
	 * Гигабит.
	 * <p>10<sup>9</sup> бит = 1 000 000 000.</p>
	 */
	GIGABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(9)
	),

	/**
	 * Терабит.
	 * <p>10<sup>12</sup> бит = 1 000 000 000 000.</p>
	 */
	TERABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(12)
	),

	/**
	 * Петабит.
	 * <p>10<sup>15</sup> бит = 1 000 000 000 000 000.</p>
	 */
	PETABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(15)
	),

	/**
	 * Эксабит.
	 * <p>10<sup>18</sup> бит = 1 000 000 000 000 000 000.</p>
	 */
	EXABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(18)
	),

	/**
	 * Зеттабит.
	 * <p>10<sup>21</sup> бит = 1 000 000 000 000 000 000 000.</p>
	 */
	ZETTABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(21)
	),

	/**
	 * Йоттабит.
	 * <p>10<sup>24</sup> бит = 1 000 000 000 000 000 000 000 000.</p>
	 */
	YOTTABIT(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(24)
	),

	/**
	 * Байт.
	 * <p>2<sup>0</sup> байт = 1.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	BYTE(
		Set.of(Standard.IEC, Standard.SI),
		new BigDecimal(1).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Кибибайт.
	 * <p>2<sup>10</sup> байт = 1 024.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	KIBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(10).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Мебибайт.
	 * <p>2<sup>20</sup> байт = 1 048 576.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	MEBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(20).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Гибибайт.
	 * <p>2<sup>30</sup> байт = 1 073 741 824.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	GIBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(30).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Тебибайт.
	 * <p>2<sup>40</sup> байт = 1 099 511 627 776.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	TEBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(40).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Пебибайт.
	 * <p>2<sup>50</sup> байт = 1 125 899 906 842 624.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	PEBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(50).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Эксбибайт.
	 * <p>2<sup>60</sup> байт = 1 152 921 504 606 846 976.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	EXBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(60).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Зебибайт.
	 * <p>2<sup>70</sup> байт = 1 180 591 620 717 411 303 424.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	ZEBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(70).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Йобибайт.
	 * <p>2<sup>80</sup> байт = 1 208 925 819 614 629 174 706 176.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	YOBIBYTE(
		Set.of(Standard.IEC),
		new BigDecimal(2).pow(80).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Килобайт.
	 * <p>10<sup>3</sup> байт = 1 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	KILOBYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(3).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Мегабайт.
	 * <p>10<sup>6</sup> байт = 1 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	MEGABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(6).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Гигабайт.
	 * <p>10<sup>9</sup> байт = 1 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	GIGABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(9).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Терабайт.
	 * <p>10<sup>12</sup> байт = 1 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	TERABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(12).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Петабайт.
	 * <p>10<sup>15</sup> байт = 1 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	PETABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(15).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Эксабайт.
	 * <p>10<sup>18</sup> байт = 1 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	EXABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(18).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Зеттабайт.
	 * <p>10<sup>21</sup> байт = 1 000 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	ZETTABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(21).multiply(BigDecimal.valueOf(8))
	),

	/**
	 * Йоттабайт.
	 * <p>10<sup>24</sup> байт = 1 000 000 000 000 000 000 000 000.</p>
	 *
	 * Данное значение умножается на 8 для конвертирования в наименьшую величину {@link InformationMeasure#BIT}.
	 */
	YOTTABYTE(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(24).multiply(BigDecimal.valueOf(8))
	);

	/**
	 * Список стандартов меры измерения.
	 */
	@Unmodifiable
	@NotNull
	private final Set<@NotNull Standard> standard;

	/**
	 * Количество минимальных единиц меры.
	 */
	@NotNull
	private final BigDecimal countMinUnit;

	/**
	 * Конструктор для {@code InformationMeasure}.
	 *
	 * @param standard список стандартов меры измерения.
	 * @param countMinUnit количество минимальных единиц меры.
	 * @throws NullPointerException если в качестве {@code standard} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code countMinUnit} передан {@code null}.
	 */
	InformationMeasure(@NotNull final Set<@NotNull Standard> standard, @NotNull final BigDecimal countMinUnit)
	{
		Objects.requireNonNull(standard);
		Objects.requireNonNull(countMinUnit);

		this.standard = standard;
		this.countMinUnit = countMinUnit;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Set<@NotNull Standard> getStandard()
	{
		return this.standard;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public BigDecimal getCountMinUnit()
	{
		return this.countMinUnit;
	}
}
