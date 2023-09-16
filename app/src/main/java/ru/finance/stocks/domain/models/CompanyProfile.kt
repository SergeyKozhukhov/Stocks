package ru.finance.stocks.domain.models

/**
 * "Профиль" кампании, представляющий общую информацию о ней
 *
 * @property country страна штаб-офиса
 * @property currency валюта
 * @property exchange "котирующаяся биржа"
 * @property finnhubIndustry отраслевая классификация
 * @property ipo дата IPO
 * @property logo изображение логотипа
 * @property marketCapitalization рыночная капитализация.
 * @property name название
 * @property phone номер
 * @property shareOutstanding количество размещенных акций
 * @property ticker символ компании/тикер, используемый на котируемой бирже
 * @property weburl company website
 */
/* https://finnhub.io/docs/api/company-profile2 */
data class CompanyProfile(
    val country: String,
    val currency: String,
    val exchange: String,
    val finnhubIndustry: String,
    val ipo: String,
    val logo: String,
    val marketCapitalization: Int,
    val name: String,
    val phone: String,
    val shareOutstanding: String,
    val ticker: String,
    val weburl: String
)