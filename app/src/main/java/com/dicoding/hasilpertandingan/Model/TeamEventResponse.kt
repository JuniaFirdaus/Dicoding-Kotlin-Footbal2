package com.dicoding.hasilpertandingan.Model

import com.google.gson.annotations.SerializedName
import com.dicoding.hasilpertandingan.Model.TeamEvent

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
data class TeamEventResponse (
        @SerializedName("teams") val teamsItems: List<TeamEvent>?
)