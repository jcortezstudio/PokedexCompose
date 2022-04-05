package com.jcortezstudio.pokedex.ui.navigation

sealed class PokeNav(val route: String) {
    object Home : PokeNav("home")
    object Detail : PokeNav("detail/{pokemonName}") {
        fun route(pokemonName: String): String = "detail/${pokemonName}"
    }
}
