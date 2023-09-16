package ru.finance.stocks.data.tickers.converters

import ru.finance.stocks.data.models.TickerEntity
import ru.finance.stocks.domain.models.Ticker


/**
 * Конвертер данных из [TickerEntity] в [Ticker]
 */
class TickerConverter {

    fun convert(source: TickerEntity) = Ticker(
        symbol = source.symbol
    )
}