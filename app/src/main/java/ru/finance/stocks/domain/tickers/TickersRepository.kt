package ru.finance.stocks.domain.tickers

import ru.finance.stocks.domain.models.Ticker

interface TickersRepository {

    suspend fun getTickers(): List<Ticker>
}