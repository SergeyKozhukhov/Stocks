package ru.finance.stocks.domain.models

/**
 * Котировочные данные
 *
 * @property currentPrice текущая цена
 * @property change изменение
 * @property percentChange процентное изменение
 * @property highPrice самая высокая цена за день
 * @property lowPrice самая низская цена за день
 * @property openPrice цена на момент открытия
 * @property previousPrice предыдущая цена закрытия
 */
/* https://finnhub.io/docs/api/quote */
data class Quote(
    val currentPrice: String, // c
    val change: String, // d
    val percentChange: String, // dp
    val highPrice: String, // h
    val lowPrice: String, // l
    val openPrice: String, // o
    val previousPrice: String // pc
)