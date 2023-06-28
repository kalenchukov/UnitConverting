/*
 * Copyright © 2023 Алексей Каленчуков
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
 * Перечисление мер измерения времени.
 *
 * @author Алексей Каленчуков
 */
public enum TimeMeasure implements Measurable
{
    /**
     * Квектосекунда.
     * <p>10<sup>-30</sup> секунды = 0.000 000 000 000 000 000 000 000 000 001.</p>
     */
    QUECTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-30, new MathContext(32))
    ),

    /**
     * Ронтосекунда.
     * <p>10<sup>-27</sup> секунды = 0.000 000 000 000 000 000 000 000 001.</p>
     */
    RONTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-27, new MathContext(32))
    ),

    /**
     * Иоктосекунда.
     * <p>10<sup>-24</sup> секунды = 0.000 000 000 000 000 000 000 001.</p>
     */
    YOCTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-24, new MathContext(32))
    ),

    /**
     * Зептосекунда.
     * <p>10<sup>-21</sup> секунды = 0.000 000 000 000 000 000 001.</p>
     */
    ZEPTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-21, new MathContext(32))
    ),

    /**
     * Аттосекунда.
     * <p>10<sup>-18</sup> секунды = 0.000 000 000 000 000 001.</p>
     */
    ATTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-18, new MathContext(32))
    ),

    /**
     * Фемтосекунда.
     * <p>10<sup>-15</sup> секунды = 0.000 000 000 000 001.</p>
     */
    FEMTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-15, new MathContext(32))
    ),

    /**
     * Пикосекунда.
     * <p>10<sup>-12</sup> секунды = 0.000 000 000 001.</p>
     */
    PICOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-12, new MathContext(32))
    ),

    /**
     * Наносекунда.
     * <p>10<sup>-9</sup> секунды = 0.000 000 001.</p>
     */
    NANOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-9, new MathContext(32))
    ),

    /**
     * Микросекунда.
     * <p>10<sup>-6</sup> секунды = 0.000 001.</p>
     */
    MICROSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-6, new MathContext(32))
    ),

    /**
     * Миллисекунда.
     * <p>10<sup>-3</sup> секунды = 0.001.</p>
     */
    MILLISECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-3, new MathContext(32))
    ),

    /**
     * Сантисекунда.
     * <p>10<sup>-2</sup> секунды = 0.01.</p>
     */
    CENTISECOND (
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-2, new MathContext(32))
    ),

    /**
     * Децисекунда.
     * <p>10<sup>-1</sup> секунды = 0.1.</p>
     */
    DECISECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(-1, new MathContext(32))
    ),

    /**
     * Секунда.
     * <p>10<sup>0</sup> секунды = 1.</p>
     */
    SECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(0)
    ),

    /**
     * Декасекунда.
     * <p>10<sup>1</sup> секунды = 10.</p>
     */
    DECASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(1)
    ),

    /**
     * Гектосекунда.
     * <p>10<sup>2</sup> секунды = 100.</p>
     */
    HECTOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(2)
    ),

    /**
     * Килосекунда.
     * <p>10<sup>3</sup> секунды = 1 000.</p>
     */
    KILOSECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(3)
    ),

    /**
     * Мегасекунда.
     * <p>10<sup>6</sup> секунды = 1 000 000.</p>
     */
    MEGASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(6)
    ),

    /**
     * Гигасекунда.
     * <p>10<sup>9</sup> секунды = 1 000 000 000.</p>
     */
    GIGASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(9)
    ),

    /**
     * Терасекунда.
     * <p>10<sup>12</sup> секунды = 1 000 000 000 000.</p>
     */
    TERASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(12)
    ),

    /**
     * Петасекунда.
     * <p>10<sup>15</sup> секунды = 1 000 000 000 000 000.</p>
     */
    PETASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(15)
    ),

    /**
     * Эксасекунда.
     * <p>10<sup>18</sup> секунды = 1 000 000 000 000 000 000.</p>
     */
    EXASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(18)
    ),

    /**
     * Зеттасекунда.
     * <p>10<sup>21</sup> секунды = 1 000 000 000 000 000 000 000.</p>
     */
    ZETTASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(21)
    ),

    /**
     * Иоттасекунда.
     * <p>10<sup>24</sup> секунды = 1 000 000 000 000 000 000 000 000.</p>
     */
    YOTTASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(24)
    ),

    /**
     * Роннасекунда.
     * <p>10<sup>27</sup> секунды = 1 000 000 000 000 000 000 000 000 000.</p>
     */
    RONNASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(27)
    ),

    /**
     * Кветтасекунда.
     * <p>10<sup>30</sup> секунды = 1 000 000 000 000 000 000 000 000 000 000.</p>
     */
    QUETTASECOND(
        Set.of(Standard.SI),
        new BigDecimal(10).pow(30)
    );

    /**
     * Список стандартов меры измерения.
     */
	@Unmodifiable
    @NotNull
    private final Set<@NotNull Standard> standard;

    /**
     * Количество минимальных единиц времени.
     */
    @NotNull
    private final BigDecimal countMinUnit;

    /**
     * Конструктор для {@code TimeMeasure}.
     *
     * @param standard список стандартов меры измерения.
     * @param countMinUnit количество минимальных единиц времени.
     * @throws NullPointerException если в качестве {@code standard} передан {@code null}.
     * @throws NullPointerException если в качестве {@code countMinUnit} передан {@code null}.
     */
    TimeMeasure(@NotNull final Set<@NotNull Standard> standard, @NotNull final BigDecimal countMinUnit)
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
