package ru.finance.stocks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import ru.finance.stocks.data.stocks.StocksRepositoryImpl
import ru.finance.stocks.data.stocks.converters.CompanyDetailsConverter
import ru.finance.stocks.data.stocks.converters.CompanyProfileConverter
import ru.finance.stocks.data.stocks.converters.QuoteConverter
import ru.finance.stocks.data.stocks.datasources.StocksDataSource
import ru.finance.stocks.data.stocks.datasources.StocksDataSourceImpl
import ru.finance.stocks.data.tickers.TickersRepositoryImpl
import ru.finance.stocks.data.tickers.converters.TickerConverter
import ru.finance.stocks.data.tickers.datasources.TickersDataSource
import ru.finance.stocks.data.tickers.datasources.TickersDataSourceImpl
import ru.finance.stocks.domain.stocks.StocksInteractor
import ru.finance.stocks.domain.stocks.StocksInteractorImpl
import ru.finance.stocks.domain.stocks.StocksRepository
import ru.finance.stocks.domain.tickers.TickersInteractor
import ru.finance.stocks.domain.tickers.TickersInteractorImpl
import ru.finance.stocks.domain.tickers.TickersRepository
import ru.finance.stocks.presentation.companydetails.CompanyDetailsViewModel
import ru.finance.stocks.presentation.tickers.TickersViewModel
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tickersViewModel = createTickersViewModel()
        val companyDetailsViewModel = createCompanyDetailsViewModel()
        setContent {
            StocksApp(
                tickersViewModel = tickersViewModel,
                companyDetailsViewModel = companyDetailsViewModel
            )
        }
    }

    private fun createTickersViewModel(): TickersViewModel {
        val tickersDataSource: TickersDataSource =
            TickersDataSourceImpl(this.applicationContext, ObjectMapper())
        val tickersRepository: TickersRepository =
            TickersRepositoryImpl(tickersDataSource, TickerConverter())
        val tickersInteractor: TickersInteractor = TickersInteractorImpl(tickersRepository)
        return ViewModelProvider(
            this, TickersViewModel.provide(tickersInteractor)
        )[TickersViewModel::class.java]
    }

    private fun createCompanyDetailsViewModel(): CompanyDetailsViewModel {
        val okHttpClient = OkHttpClient.Builder().readTimeout(3000, TimeUnit.MILLISECONDS)
            .writeTimeout(3000, TimeUnit.MILLISECONDS).build()

        val objectMapper = ObjectMapper()
        val stocksDataSource: StocksDataSource = StocksDataSourceImpl(okHttpClient, objectMapper)

        val profileConverter = CompanyProfileConverter()
        val quoteConverter = QuoteConverter()
        val companyDetailsConverter = CompanyDetailsConverter(profileConverter, quoteConverter)

        val stocksRepository: StocksRepository =
            StocksRepositoryImpl(stocksDataSource, companyDetailsConverter)
        val stocksInteractor: StocksInteractor = StocksInteractorImpl(stocksRepository)

        return ViewModelProvider(
            this, CompanyDetailsViewModel.provide(stocksInteractor)
        )[CompanyDetailsViewModel::class.java]
    }
}