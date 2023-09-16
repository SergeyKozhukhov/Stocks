package ru.finance.stocks.data.tickers.datasources

import android.content.Context
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import ru.finance.stocks.data.models.TickerEntity

class TickersDataSourceImpl(
    private val context: Context, private val objectMapper: ObjectMapper
) : TickersDataSource {

    private val typeReference = object : TypeReference<List<TickerEntity>>() {}

    override fun getTickers(): List<TickerEntity> =
        objectMapper.readValue(context.assets.open(TICKERS_FILE), typeReference)

    private companion object {
        const val TICKERS_FILE = "tickers.json"
    }
}