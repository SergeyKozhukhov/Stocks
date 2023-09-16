package ru.finance.stocks.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Котировочные данные
 *
 * @property c текущая цена
 * @property d изменение
 * @property dp процентное изменение
 * @property h самая высокая цена за день
 * @property l самая низская цена за день
 * @property o цена на момент открытия
 * @property pc предыдущая цена закрытия
 */
/* https://finnhub.io/docs/api/quote */
@JsonIgnoreProperties(ignoreUnknown = true) // unknown param "t"
data class QuoteEntity(
    @JsonProperty("c") val c: String,
    @JsonProperty("d") val d: String,
    @JsonProperty("dp") val dp: String,
    @JsonProperty("h") val h: String,
    @JsonProperty("l") val l: String,
    @JsonProperty("o") val o: String,
    @JsonProperty("pc") val pc: String
)