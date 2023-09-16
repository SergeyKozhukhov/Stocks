package ru.finance.stocks.domain.tickers

class TickersInteractorImpl(private val tickersRepository: TickersRepository) : TickersInteractor {

    override suspend fun getTickers() = tickersRepository.getTickers()
}