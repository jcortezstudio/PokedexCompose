package com.jcortezstudio.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class Move (
    var move: Move2,
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>
)