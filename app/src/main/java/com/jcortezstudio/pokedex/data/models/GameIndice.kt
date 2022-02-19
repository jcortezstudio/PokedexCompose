package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    var version: Version
)