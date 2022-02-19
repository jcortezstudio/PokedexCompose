package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class GenerationIV(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)