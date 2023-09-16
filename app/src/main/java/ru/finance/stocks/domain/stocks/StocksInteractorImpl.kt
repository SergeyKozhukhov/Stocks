package ru.finance.stocks.domain.stocks

class StocksInteractorImpl(private val stocksRepository: StocksRepository) : StocksInteractor {

    override suspend fun getCompanyDetails(symbol: String) =
        stocksRepository.getCompanyDetails(symbol)
}