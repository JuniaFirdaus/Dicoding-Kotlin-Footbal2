package com.dicoding.hasilpertandingan.Model

import com.google.gson.annotations.SerializedName
import com.dicoding.hasilpertandingan.Model.DetailEvent
/**
 * Created by ${JUNIA} on 9/2/2018.
 */

data class DetailEventResponse(
        @SerializedName("events") val detailItems: List<DetailEvent>?
)