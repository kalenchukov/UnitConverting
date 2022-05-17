/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unitconverter;

import dev.kalenchukov.unitconverter.sources.Measurable;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * Интерфейс для реализации класса величин.
 *
 * @param <M> Тип объекта меры измерения величины.
 */
public interface Quantitative<M extends Measurable>
{
	/**
	 * Возвращает величину.
	 *
	 * @return Величину.
	 */
	@NotNull
	BigDecimal getQuantity();

	/**
	 * Возвращает меру измерения величины.
	 *
	 * @return Мера измерения величины.
	 */
	@NotNull M getMeasure();

//	/**
//	 * Конвертирует величину в предельно возможную меру до целого.
//	 *
//	 * @return Величина.
//	 */
//	@NotNull
//	BigDecimal convert();

//	/**
//	 * Конвертирует величину в предельно возможную меру до целого по стандарту.
//	 *
//	 * @return Величина.
//	 */
//	@NotNull
//	BigDecimal convert(@NotNull final Standard standard);

	/**
	 * Конвертирует величину в указанную меру измерения.
	 *
	 * @param measure Мера измерения величины.
	 * @return Величина.
	 */
	@NotNull
	BigDecimal convert(@NotNull final M measure);
}
