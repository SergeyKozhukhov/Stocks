package ru.finance.stocks.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Тикер
 *
 * @property symbol символ
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class TickerData(
    @JsonProperty("symbol") val symbol: String
)