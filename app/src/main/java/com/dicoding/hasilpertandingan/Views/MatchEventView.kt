package com.dicoding.hasilpertandingan.Views

import com.dicoding.hasilpertandingan.Model.MatchEvent
/**
 * Created by ${JUNIA} on 9/2/2018.
 */

interface MatchEventView {
    fun showLoading()
    fun hideLoading()
    fun showMatch(data: List<MatchEvent>?)
    fun showNull()
}