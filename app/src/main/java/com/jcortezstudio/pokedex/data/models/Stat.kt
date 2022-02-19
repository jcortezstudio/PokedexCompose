package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: Stat2
)