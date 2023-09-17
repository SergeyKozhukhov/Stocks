package ru.finance.stocks.presentation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface ScreenDestination {
    val route: String

    object Tickers : ScreenDestination {
        override val route = "tickers"
    }

    object CompanyDetails : ScreenDestination {
        override val route = "company_details"
        const val SYMBOL_ARG = "symbol"
        val routeWithArg = "${route}/{${SYMBOL_ARG}}"
        val arguments = listOf(navArgument(SYMBOL_ARG) { type = NavType.StringType })
    }
}