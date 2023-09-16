package ru.finance.stocks.presentation.companydetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.finance.stocks.domain.stocks.StocksInteractor

class CompanyDetailsViewModel(
    private val stocksInteractor: StocksInteractor
) : ViewModel() {

    val uiState: StateFlow<CompanyDetailsUiState> get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow<CompanyDetailsUiState>(CompanyDetailsUiState.Loading)

    fun loadCompanyDetails(symbol: String) {
        viewModelScope.launch {
            val details = stocksInteractor.getCompanyDetails(symbol)
            _uiState.value = CompanyDetailsUiState.Success(details)
        }
    }

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun provide(stocksInteractor: StocksInteractor) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CompanyDetailsViewModel(stocksInteractor) as T
            }
        }
    }
}