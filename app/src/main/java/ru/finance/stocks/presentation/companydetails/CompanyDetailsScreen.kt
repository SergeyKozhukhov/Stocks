package ru.finance.stocks.presentation.companydetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.finance.stocks.domain.models.CompanyDetails
import ru.finance.stocks.domain.models.CompanyProfile
import ru.finance.stocks.domain.models.Quote
import ru.finance.stocks.presentation.ui.theme.StocksTheme

@Composable
fun CompanyDetailsScreen(viewModel: CompanyDetailsViewModel, symbol: String = "AAPL") {
    LaunchedEffect(true) {
        viewModel.loadCompanyDetails(symbol)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        CompanyDetailsUiState.Loading -> {}
        is CompanyDetailsUiState.Success -> {
            CompanyDetailsItem(details = (uiState as CompanyDetailsUiState.Success).details)
        }
    }
}

@Composable
private fun CompanyDetailsItem(details: CompanyDetails) {
    Column {
        Text(text = details.profile.name)
        Text(text = details.profile.ticker)
        Text(text = details.quote.currentPrice)
    }
}

@Preview(showBackground = true)
@Composable
private fun CompanyDetailsItemPreview() {
    val details = CompanyDetails(
        profile = CompanyProfile(
            country = "country",
            currency = "currency",
            exchange = "exchange",
            finnhubIndustry = "finnhubIndustry",
            ipo = "ipo",
            logo = "logo",
            marketCapitalization = 123,
            name = "name",
            phone = "phone",
            shareOutstanding = "shareOutstanding",
            ticker = "ticker",
            weburl = "weburl"
        ), quote = Quote(
            currentPrice = "currentPrice",
            change = "change",
            percentChange = "percentChange",
            highPrice = "highPrice",
            lowPrice = "lowPrice",
            openPrice = "openPrice",
            previousPrice = "previousPrice"
        )
    )
    StocksTheme {
        CompanyDetailsItem(details)
    }
}