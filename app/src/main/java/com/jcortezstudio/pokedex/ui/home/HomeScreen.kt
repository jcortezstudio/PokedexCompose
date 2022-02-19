package com.jcortezstudio.pokedex.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.jcortezstudio.pokedex.ui.home.HomeViewModel
import com.jcortezstudio.pokedex.ui.components.AppBar
import com.jcortezstudio.pokedex.ui.components.PokemonCard
import com.jcortezstudio.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        AppBar("Pokédex")
    }, content = {
        PokedexTheme {
            Surface(color = MaterialTheme.colors.background) {
                PokemonList()
            }
        }
    })
}

@ExperimentalFoundationApi
@Composable
fun PokemonList(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val lazyPokemonItems = homeViewModel.pokemonList.collectAsLazyPagingItems()
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        cells = GridCells.Fixed(2),
        content = {
            items(lazyPokemonItems.itemCount) { index ->
                lazyPokemonItems[index]?.let {
                    val pokemon = homeViewModel.buildPokemonItem(it)
                    PokemonCard(pokemon = pokemon){

                    }
                }
            }
        })
}