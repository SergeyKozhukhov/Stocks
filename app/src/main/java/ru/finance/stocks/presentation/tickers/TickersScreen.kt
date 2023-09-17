package ru.finance.stocks.presentation.tickers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.finance.stocks.domain.models.Ticker
import ru.finance.stocks.presentation.tickers.models.TickersUiState
import ru.finance.stocks.presentation.ui.theme.StocksTheme

@Composable
fun TickersScreen(
    viewModel: TickersViewModel,
    onItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(true) {
        viewModel.loadTickers()
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        TickersUiState.Loading -> {}
        is TickersUiState.Success -> {
            TickerItems(
                tickers = (uiState as TickersUiState.Success).tickers,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Composable
private fun TickerItems(tickers: List<Ticker>, onItemClicked: (String) -> Unit) {
    LazyColumn {
        items(tickers) { ticker ->
            TickerItem(ticker = ticker, onItemClicked = onItemClicked)
        }
    }
}

@Composable
private fun TickerItem(ticker: Ticker, onItemClicked: (String) -> Unit) {
    Text(
        text = ticker.symbol,
        modifier = Modifier.clickable { onItemClicked.invoke(ticker.symbol) }
    )
}

@Preview(showBackground = true)
@Composable
private fun TickerItemPreview() {
    val ticker = Ticker("symbol")
    StocksTheme {
        TickerItem(ticker) {}
    }
}