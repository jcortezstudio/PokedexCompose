package com.jcortezstudio.pokedex.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.jcortezstudio.pokedex.Constants
import com.jcortezstudio.pokedex.R
import com.jcortezstudio.pokedex.ui.PokedexApp
import com.jcortezstudio.pokedex.ui.components.AppBar
import com.jcortezstudio.pokedex.ui.components.PokemonCard
import com.jcortezstudio.pokedex.ui.navigation.PokeNav

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(topBar = {
        AppBar(Constants.APP_NAME)
    }, content = {
        PokedexApp {
            PokemonList(navController)
        }
    })
}

@ExperimentalFoundationApi
@Composable
fun PokemonList(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val lazyPokemonItems = homeViewModel.pokemonList.collectAsLazyPagingItems()
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        cells = GridCells.Fixed(2),
        content = {
            items(lazyPokemonItems.itemCount) { index ->
                lazyPokemonItems[index]?.let {
                    val pokemon = homeViewModel.buildPokemonItem(it)
                    PokemonCard(pokemon = pokemon) {
                        navController.navigate(
                            PokeNav.Detail.route(it.name)
                        )
                    }
                }
            }
        })
}