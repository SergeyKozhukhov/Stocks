package ru.finance.stocks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.fasterxml.jackson.databind.ObjectMapper
import ru.finance.stocks.data.tickers.TickersRepositoryImpl
import ru.finance.stocks.data.tickers.converters.TickerConverter
import ru.finance.stocks.data.tickers.datasources.TickersDataSource
import ru.finance.stocks.data.tickers.datasources.TickersDataSourceImpl
import ru.finance.stocks.domain.tickers.TickersRepository
import ru.finance.stocks.presentation.tickers.TickersScreen
import ru.finance.stocks.presentation.tickers.TickersViewModel
import ru.finance.stocks.presentation.ui.theme.StocksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = createViewModel()
        setContent {
            StocksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TickersScreen(viewModel)
                }
            }
        }
    }

    private fun createViewModel(): TickersViewModel {
        val tickersDataSource: TickersDataSource =
            TickersDataSourceImpl(this.applicationContext, ObjectMapper())
        val tickersRepository: TickersRepository =
            TickersRepositoryImpl(tickersDataSource, TickerConverter())
        return ViewModelProvider(
            this,
            TickersViewModel.provide(tickersRepository)
        )[TickersViewModel::class.java]
    }
}