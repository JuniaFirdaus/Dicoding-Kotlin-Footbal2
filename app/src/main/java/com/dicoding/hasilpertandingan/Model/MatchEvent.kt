package com.dicoding.hasilpertandingan.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
data class MatchEvent (

        @SerializedName("idEvent")
        var idEvent: String? = null,

        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = null,

        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = null,

        @SerializedName("strDate")
        var strDate: String? = null,

        @SerializedName("strHomeTeam")
        var strHomeTeam: String? = null,

        @SerializedName("strAwayTeam")
        var strAwayTeam: String? = null,

        @SerializedName("intHomeScore")
        var intHomeScore: String? = null,

        @SerializedName("intAwayScore")
        var intAwayScore: String? = null


)