package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class Icons2(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)