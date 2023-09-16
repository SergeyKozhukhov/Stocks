package ru.finance.stocks.presentation.companydetails

import ru.finance.stocks.domain.models.CompanyDetails

sealed interface CompanyDetailsUiState {

    object Loading : CompanyDetailsUiState

    data class Success(val details: CompanyDetails) : CompanyDetailsUiState
}