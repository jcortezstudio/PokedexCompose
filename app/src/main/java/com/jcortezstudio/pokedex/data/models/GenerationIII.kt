package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class GenerationIII(
    val emerald: Emerald,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphire
)