package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class GenerationVII(
    val icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)