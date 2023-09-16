package ru.finance.stocks.data.tickers.datasources

import ru.finance.stocks.data.models.TickerEntity

interface TickersDataSource {

    fun getTickers(): List<TickerEntity>
}