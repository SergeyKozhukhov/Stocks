package ru.finance.stocks.domain.models

/**
 * Детальная информация о кампании, вклюаящая в себя текущее состояние котировочных данных
 *
 * @property profile "профиль" кампании, представляющий общую информацию о ней
 * @property quote котировочные данные
 */
data class CompanyDetails(
    val profile: CompanyProfile,
    val quote: Quote
)