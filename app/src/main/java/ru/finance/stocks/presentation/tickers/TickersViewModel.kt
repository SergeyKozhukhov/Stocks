package ru.finance.stocks.presentation.tickers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.finance.stocks.domain.tickers.TickersInteractor
import ru.finance.stocks.presentation.tickers.models.TickersUiState

class TickersViewModel(private val tickersInteractor: TickersInteractor) : ViewModel() {

    val uiState: StateFlow<TickersUiState> get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow<TickersUiState>(TickersUiState.Loading)

    fun loadTickers() {
        viewModelScope.launch {
            val tickers = tickersInteractor.getTickers()
            _uiState.value = TickersUiState.Success(tickers)
        }
    }

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun provide(tickersInteractor: TickersInteractor) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TickersViewModel(tickersInteractor) as T
            }
        }
    }
}