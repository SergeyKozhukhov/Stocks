package ru.finance.stocks.data.stocks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import ru.finance.stocks.data.stocks.converters.CompanyDetailsConverter
import ru.finance.stocks.data.stocks.datasources.StocksDataSource
import ru.finance.stocks.domain.stocks.StocksRepository

class StocksRepositoryImpl(
    private val stocksDataSource: StocksDataSource,
    private val converter: CompanyDetailsConverter
) : StocksRepository {

    override suspend fun getCompanyDetails(symbol: String) = withContext(Dispatchers.IO) {
        val companyProfileDeferred = async { stocksDataSource.getCompanyProfile(symbol) }
        val quoteDeferred = async { stocksDataSource.getQuote(symbol) }
        converter.convert(profile = companyProfileDeferred.await(), quote = quoteDeferred.await())
    }
}