package ru.finance.stocks.data.stocks.converters

import ru.finance.stocks.data.models.CompanyProfileEntity
import ru.finance.stocks.domain.models.CompanyProfile

/**
 * Конвертер данных из [CompanyProfileEntity] в [CompanyProfile]
 */
class CompanyProfileConverter {

    fun convert(source: CompanyProfileEntity) = CompanyProfile(
        country = source.country,
        currency = source.currency,
        exchange = source.exchange,
        finnhubIndustry = source.finnhubIndustry,
        ipo = source.ipo,
        logo = source.logo,
        marketCapitalization = source.marketCapitalization,
        name = source.name,
        phone = source.phone,
        shareOutstanding = source.shareOutstanding,
        ticker = source.ticker,
        weburl = source.weburl
    )
}