package com.jcortezstudio.pokedex.ui.home

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jcortezstudio.pokedex.Constants
import com.jcortezstudio.pokedex.data.models.PokemonFactoryItem
import com.jcortezstudio.pokedex.data.models.PokemonResult
import com.jcortezstudio.pokedex.data.remote.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    var pokemonList: Flow<PagingData<PokemonResult>> = pokemonRepository.getPokemonList()

    fun buildPokemonItem(item: PokemonResult): PokemonFactoryItem {
        val number = if (item.url.endsWith("/")) {
            item.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            item.url.takeLastWhile { it.isDigit() }
        }
        val url = "${Constants.URL_IMAGE}${number}${Constants.IMAGE_EXT}"
        return PokemonFactoryItem(item.name.capitalize(Locale.ROOT), url, number.toInt())
    }
}