package com.jcortezstudio.pokedex.di

import com.jcortezstudio.pokedex.data.remote.PokemonRepository
import com.jcortezstudio.pokedex.data.remote.ServerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLicenseRepository(
        api: ServerApi
    ) = PokemonRepository(api)

}