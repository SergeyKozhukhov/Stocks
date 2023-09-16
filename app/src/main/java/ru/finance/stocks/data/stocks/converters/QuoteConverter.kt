package ru.finance.stocks.data.stocks.converters

import ru.finance.stocks.data.models.QuoteEntity
import ru.finance.stocks.domain.models.Quote

/**
 * Конвертер данных из [QuoteEntity] в [Quote]
 */
class QuoteConverter {

    fun convert(source: QuoteEntity) = Quote(
        currentPrice = source.c, // c
        change = source.d, // d
        percentChange = source.dp, // dp
        highPrice = source.h, // h
        lowPrice = source.l, // l
        openPrice = source.o, // o
        previousPrice = source.pc // pc
    )
}