package ru.finance.stocks.presentation.tickers.models

import ru.finance.stocks.domain.models.Ticker

sealed interface TickersUiState {

    object Loading : TickersUiState

    data class Success(val tickers: List<Ticker>) : TickersUiState
}