package com.jcortezstudio.pokedex.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jcortezstudio.pokedex.data.PokemonSource
import com.jcortezstudio.pokedex.data.models.PokemonResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val api: ServerApi) {

    fun getPokemonList(): Flow<PagingData<PokemonResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PokemonSource(api)
            }
        ).flow
    }
}