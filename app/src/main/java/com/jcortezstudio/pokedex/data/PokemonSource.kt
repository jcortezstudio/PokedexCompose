package com.jcortezstudio.pokedex.data

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jcortezstudio.pokedex.data.models.PokemonResult
import com.jcortezstudio.pokedex.data.remote.ServerApi
import javax.inject.Inject

private const val INITIAL_LOAD_SIZE = 0

class PokemonSource @Inject constructor(private val api: ServerApi) :
    PagingSource<Int, PokemonResult>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonResult>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonResult> {
        val nextPage = params.key ?: INITIAL_LOAD_SIZE
        return try {
            val response = api.getPokemonList(limit = params.loadSize, offset = nextPage)
            val nextKey = if (response.body()!!.next.isNullOrEmpty()) {
                null
            } else {
                extractOffsetUrl(response.body()!!.next)
            }
            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

    private fun extractOffsetUrl(url: String): Int {
        val uri = Uri.parse(url)
        return uri.getQueryParameter("offset")!!.toInt()
    }
}