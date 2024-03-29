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

package dev.kalenchukov.unit.converting.resources;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Set;
import java.util.Objects;

/**
 * Перечисление мер измерения массы.
 *
 * @author Алексей Каленчуков
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
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-24, new MathContext(32))
	),

	/**
	 * Зептограмм.
	 * <p>10<sup>-21</sup> грамма = 0.000 000 000 000 000 000 001.</p>
	 */
	ZEPTOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-21, new MathContext(32))
	),

	/**
	 * Аттограмм.
	 * <p>10<sup>-18</sup> грамма = 0.000 000 000 000 000 001.</p>
	 */
	ATTOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-18, new MathContext(32))
	),

	/**
	 * Фемтограмм.
	 * <p>10<sup>-15</sup> грамма = 0.000 000 000 000 001.</p>
	 */
	FEMTOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-15, new MathContext(32))
	),

	/**
	 * Пикограмм.
	 * <p>10<sup>-12</sup> грамма = 0.000 000 000 001.</p>
	 */
	PICOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-12, new MathContext(32))
	),

	/**
	 * Нанограмм.
	 * <p>10<sup>-9</sup> грамма = 0.000 000 001.</p>
	 */
	NANOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-9, new MathContext(32))
	),

	/**
	 * Микрограмм.
	 * <p>10<sup>-6</sup> грамма = 0.000 001.</p>
	 */
	MICROGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-6, new MathContext(32))
	),

	/**
	 * Миллиграмм.
	 * <p>10<sup>-3</sup> грамма = 0.001.</p>
	 */
	MILLIGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-3, new MathContext(32))
	),

	/**
	 * Сантиграмм.
	 * <p>10<sup>-2</sup> грамма = 0.01.</p>
	 */
	CENTIGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-2, new MathContext(32))
	),

	/**
	 * Дециграмм.
	 * <p>10<sup>-1</sup> грамма = 0.1.</p>
	 */
	DECIGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(-1, new MathContext(32))
	),

	/**
	 * Грамм.
	 * <p>10<sup>-0</sup> грамма = 1.</p>
	 */
	GRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(0)
	),

	/**
	 * Декаграмм.
	 * <p>10<sup>1</sup> грамма = 10.</p>
	 */
	DECAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(1)
	),

	/**
	 * Гектограмм.
	 * <p>10<sup>2</sup> грамма = 100.</p>
	 */
	HECTOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(2)
	),

	/**
	 * Килограмм.
	 * <p>10<sup>3</sup> грамма = 1 000.</p>
	 */
	KILOGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(3)
	),

	/**
	 * Мегаграмм.
	 * <p>10<sup>6</sup> грамма = 1 000 000.</p>
	 */
	MEGAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(6)
	),

	/**
	 * Гигаграмм.
	 * <p>10<sup>9</sup> грамма = 1 000 000 000.</p>
	 */
	GIGAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(9)
	),

	/**
	 * Тераграмм.
	 * <p>10<sup>12</sup> грамма = 1 000 000 000 000.</p>
	 */
	TERAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(12)
	),

	/**
	 * Петаграмм.
	 * <p>10<sup>15</sup> грамма = 1 000 000 000 000 000.</p>
	 */
	PETAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(15)
	),

	/**
	 * Эксаграмм.
	 * <p>10<sup>18</sup> грамма = 1 000 000 000 000 000 000.</p>
	 */
	EXAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(18)
	),

	/**
	 * Зеттаграмм.
	 * <p>10<sup>21</sup> грамма = 1 000 000 000 000 000 000 000.</p>
	 */
	ZETTAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(21)
	),

	/**
	 * Йоттаграмм.
	 * <p>10<sup>24</sup> грамма = 1 000 000 000 000 000 000 000 000.</p>
	 */
	YOTTAGRAM(
		Set.of(Standard.SI),
		new BigDecimal(10).pow(24)
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
	 * Конструктор для {@code MassMeasure}.
	 *
	 * @param standard список стандартов меры измерения.
	 * @param countMinUnit количество минимальных единиц меры.
	 * @throws NullPointerException если в качестве {@code standard} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code countMinUnit} передан {@code null}.
	 */
	MassMeasure(@NotNull final Set<@NotNull Standard> standard, @NotNull final BigDecimal countMinUnit)
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
