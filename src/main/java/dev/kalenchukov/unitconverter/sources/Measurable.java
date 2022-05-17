/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.unitconverter.sources;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;

/**
 * Интерфейс для реализации перечисления мер измерения.
 */
public interface Measurable
{
	/**
	 * Возвращает стандарт.
	 *
	 * @return Коллекцию стандартов.
	 */
	@NotNull
	List<@NotNull Standard> getStandard();

	/**
	 * Возвращает количество минимальных единиц меры.
	 *
	 * @return Количество минимальных единиц меры.
	 */
	@NotNull
	BigDecimal getCountMinUnit();
}
