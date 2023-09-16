package ru.finance.stocks.domain.stocks

import ru.finance.stocks.domain.models.CompanyDetails

interface StocksRepository {

    suspend fun getCompanyDetails(symbol: String): CompanyDetails
}