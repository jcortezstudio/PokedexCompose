package com.jcortezstudio.pokedex.data.models


import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i")
    val generationI: GenerationI,
    @SerializedName("generation-ii")
    val generationIi: GenerationII,
    @SerializedName("generation-iii")
    val generationIii: GenerationIII,
    @SerializedName("generation-iv")
    val generationIv: GenerationIV,
    @SerializedName("generation-v")
    val generationV: GenerationV,
    @SerializedName("generation-vi")
    val generationVi: GenerationVI,
    @SerializedName("generation-vii")
    val generationVii: GenerationVII,
    @SerializedName("generation-viii")
    val generationViii: GenerationVIII
)