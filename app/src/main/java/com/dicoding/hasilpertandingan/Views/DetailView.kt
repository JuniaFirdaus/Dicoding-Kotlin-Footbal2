package com.dicoding.hasilpertandingan.Views

import com.dicoding.hasilpertandingan.Model.DetailEvent
import com.dicoding.hasilpertandingan.Model.TeamEvent

/**
 * Created by ${JUNIA} on 9/2/2018.
 */

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showDetail(detail: List<DetailEvent>?, home: List<TeamEvent>?, away: List<TeamEvent>?)
    fun showBadge()
}