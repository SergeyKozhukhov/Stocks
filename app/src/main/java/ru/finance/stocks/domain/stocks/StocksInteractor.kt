package ru.finance.stocks.domain.stocks

import ru.finance.stocks.domain.models.CompanyDetails

interface StocksInteractor {

    suspend fun getCompanyDetails(symbol: String): CompanyDetails
}