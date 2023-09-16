package ru.finance.stocks.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

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
@JsonIgnoreProperties(ignoreUnknown = true)
data class CompanyProfileEntity(
    @JsonProperty("country") val country: String,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("exchange") val exchange: String,
    @JsonProperty("finnhubIndustry") val finnhubIndustry: String,
    @JsonProperty("ipo") val ipo: String,
    @JsonProperty("logo") val logo: String,
    @JsonProperty("marketCapitalization") val marketCapitalization: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("phone") val phone: String,
    @JsonProperty("shareOutstanding") val shareOutstanding: String,
    @JsonProperty("ticker") val ticker: String,
    @JsonProperty("weburl") val weburl: String
)