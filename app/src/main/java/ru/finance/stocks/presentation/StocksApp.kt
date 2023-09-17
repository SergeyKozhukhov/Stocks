package ru.finance.stocks.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.finance.stocks.presentation.companydetails.CompanyDetailsScreen
import ru.finance.stocks.presentation.companydetails.CompanyDetailsViewModel
import ru.finance.stocks.presentation.tickers.TickersScreen
import ru.finance.stocks.presentation.tickers.TickersViewModel
import ru.finance.stocks.presentation.ui.theme.StocksTheme

@Composable
fun StocksApp(
    tickersViewModel: TickersViewModel,
    companyDetailsViewModel: CompanyDetailsViewModel
) {
    StocksTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            StocksNavHost(
                navController = navController,
                tickersViewModel = tickersViewModel,
                companyDetailsViewModel = companyDetailsViewModel
            )
        }
    }
}

@Composable
private fun StocksNavHost(
    navController: NavHostController,
    tickersViewModel: TickersViewModel,
    companyDetailsViewModel: CompanyDetailsViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ScreenDestination.Tickers.route,
        modifier = modifier
    ) {
        composable(route = ScreenDestination.Tickers.route) {
            TickersScreen(
                viewModel = tickersViewModel,
                onItemClicked = { symbol -> navController.navigate("${ScreenDestination.CompanyDetails.route}/$symbol") }
            )
        }
        composable(
            route = ScreenDestination.CompanyDetails.routeWithArg,
            arguments = ScreenDestination.CompanyDetails.arguments
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString(ScreenDestination.CompanyDetails.SYMBOL_ARG)
                ?.let { symbol ->
                    CompanyDetailsScreen(viewModel = companyDetailsViewModel, symbol = symbol)
                }
        }
    }
}