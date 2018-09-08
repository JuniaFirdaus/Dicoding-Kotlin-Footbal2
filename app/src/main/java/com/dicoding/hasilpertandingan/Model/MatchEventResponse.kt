package com.dicoding.hasilpertandingan.Model

import com.google.gson.annotations.SerializedName
import com.dicoding.hasilpertandingan.Model.MatchEvent
/**
 * Created by ${JUNIA} on 9/2/2018.
 */

data class MatchEventResponse (
        @SerializedName("events") val matchItems: List<MatchEvent>?)