package ru.finance.stocks.data.stocks.converters

import ru.finance.stocks.data.models.CompanyProfileEntity
import ru.finance.stocks.data.models.QuoteEntity
import ru.finance.stocks.domain.models.CompanyDetails

class CompanyDetailsConverter(
    private val profileConverter: CompanyProfileConverter,
    private val quoteConverter: QuoteConverter
) {

    fun convert(profile: CompanyProfileEntity, quote: QuoteEntity) = CompanyDetails(
        profile = profileConverter.convert(profile),
        quote = quoteConverter.convert(quote)
    )
}