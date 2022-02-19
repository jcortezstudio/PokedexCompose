package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class Ability(
    var ability: Ability2,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    var slot: Int
)