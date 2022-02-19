package com.jcortezstudio.pokedex.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jcortezstudio.pokedex.data.models.PokemonFactoryItem
import com.jcortezstudio.pokedex.data.models.PokemonResult
import com.jcortezstudio.pokedex.data.remote.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    var pokemonList: Flow<PagingData<PokemonResult>> = flowOf()

    init {
        getPokemonList()
    }

    private fun getPokemonList() = viewModelScope.launch {
        pokemonList = pokemonRepository.getPokemonList().cachedIn(viewModelScope)
    }

    fun buildPokemonItem(item: PokemonResult): PokemonFactoryItem {
        val number = if (item.url.endsWith("/")) {
            item.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            item.url.takeLastWhile { it.isDigit() }
        }
        val url =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${number}.png"
        return PokemonFactoryItem(item.name.capitalize(Locale.ROOT), url, number.toInt())
    }
}