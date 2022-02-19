package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class GenerationVI(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xY: XY
)