package ru.finance.stocks.data.tickers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.finance.stocks.data.tickers.converters.TickerConverter
import ru.finance.stocks.data.tickers.datasources.TickersDataSource
import ru.finance.stocks.domain.models.Ticker
import ru.finance.stocks.domain.tickers.TickersRepository

class TickersRepositoryImpl(
    private val tickersDataSource: TickersDataSource,
    private val tickersConverter: TickerConverter
) : TickersRepository {

    override suspend fun getTickers(): List<Ticker> = withContext(Dispatchers.IO) {
        tickersDataSource.getTickers().map { tickersConverter.convert(it) }
    }
}