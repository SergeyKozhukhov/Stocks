package ru.finance.stocks.data.stocks.datasources

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.finance.stocks.BuildConfig
import ru.finance.stocks.data.models.CompanyProfileEntity
import ru.finance.stocks.data.models.QuoteEntity
import ru.finance.stocks.data.models.expections.FailedServerResponse

class StocksDataSourceImpl(
    private val okHttpClient: OkHttpClient,
    private val objectMapper: ObjectMapper
) : StocksDataSource {

    override fun getCompanyProfile(symbol: String): CompanyProfileEntity {
        val url = getProfileUrl(symbol)
        val request = buildRequest(url)

        val response = okHttpClient.newCall(request).execute()

        if (response.isSuccessful) {
            val result = response.body?.string()
            return objectMapper.readValue(result, CompanyProfileEntity::class.java)
        }

        throw FailedServerResponse()
    }

    override fun getQuote(symbol: String): QuoteEntity {
        val url = getQuoteUrl(symbol)
        val request = buildRequest(url)

        val response = okHttpClient.newCall(request).execute()

        if (response.isSuccessful) {
            val body = response.body
            val res = body?.string()
            return objectMapper.readValue(res, QuoteEntity::class.java)
        }

        throw FailedServerResponse()
    }


    private fun buildRequest(url: String) = Request.Builder().url(url.toHttpUrl()).get().build()

    private fun getProfileUrl(symbol: String) = "$PROFILE_PATH$symbol$TOKEN_PATH"

    private fun getQuoteUrl(symbol: String) = "$QUOTE_PATH$symbol$TOKEN_PATH"

    private companion object {
        const val PROFILE_PATH = "https://finnhub.io/api/v1/stock/profile2?symbol="
        const val QUOTE_PATH = "https://finnhub.io/api/v1/quote?symbol="

        const val TOKEN_PATH = "&token=${BuildConfig.API_KEY}"
    }
}