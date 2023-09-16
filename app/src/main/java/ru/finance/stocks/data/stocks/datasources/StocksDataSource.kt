package ru.finance.stocks.data.stocks.datasources

import ru.finance.stocks.data.models.CompanyProfileEntity
import ru.finance.stocks.data.models.QuoteEntity

interface StocksDataSource {

    fun getCompanyProfile(symbol: String): CompanyProfileEntity

    fun getQuote(symbol: String): QuoteEntity
}