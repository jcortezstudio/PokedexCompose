package com.jcortezstudio.pokedex.data.remote

import com.jcortezstudio.pokedex.data.models.Pokemon
import com.jcortezstudio.pokedex.data.models.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServerApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonList>

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Response<Pokemon>
}