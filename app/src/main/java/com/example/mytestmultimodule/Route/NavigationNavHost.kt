package com.example.mytestmultimodule.Route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.navigation
import androidx.navigation.compose.composable
import com.example.search.art_details.ArtDetailsScreenRoot
import com.example.search.art_list.ArtListScreenRoot
import com.example.search.art_list.ArtListViewModel

@Composable
fun NavigationNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.RootGraph
    ) {
        navigation<Route.RootGraph>(
            startDestination = Route.ArtList
        ) {

            composable<Route.ArtList> {
                val viewModel = hiltViewModel<ArtListViewModel>()
                ArtListScreenRoot(
                    modifier = modifier,
                    viewModel = viewModel,
                    onClickArt = {art ->
                        navController.navigate(
                            Route.ArtDetails(art.id)
                        )
                    }
                )
            }

            composable<Route.ArtDetails> {

                ArtDetailsScreenRoot(
                    modifier = modifier,
                    onClick = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}