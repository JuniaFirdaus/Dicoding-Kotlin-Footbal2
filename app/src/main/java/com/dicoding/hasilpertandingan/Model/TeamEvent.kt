package com.dicoding.hasilpertandingan.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
data class TeamEvent (

        //Team Details
        @SerializedName("strTeamBadge")
        val strTeamBadge: String? = null,

        @SerializedName("strManager")
        val strManager: String? = null

)