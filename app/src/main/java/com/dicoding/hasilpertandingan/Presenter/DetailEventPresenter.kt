package com.dicoding.hasilpertandingan.Presenter

import com.dicoding.hasilpertandingan.Repository.ApiRepository
import com.dicoding.hasilpertandingan.Views.DetailView
import com.dicoding.hasilpertandingan.Model.DetailEventResponse
import com.dicoding.hasilpertandingan.Model.TeamEventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
/**
 * Created by ${JUNIA} on 9/2/2018.
 */

class DetailEventPresenter (
        private val view: DetailView,
        private val apiRepository: ApiRepository,
        private val gson: Gson
) {

    fun loadDetailMatch(homeId: String?, awayId: String?, matchId: String?) {
        view.showLoading()

        doAsync {
            val reqEventHome = apiRepository.reqEvent(homeId)
            val reqEventAwayTeam = apiRepository.reqEvent(awayId)
            val reqEventDetail = apiRepository.reqDetail(matchId)
            val homeEvent = Gson().fromJson(reqEventHome, TeamEventResponse::class.java)
            val awayEvent = Gson().fromJson(reqEventAwayTeam, TeamEventResponse::class.java)
            val detailEvent = Gson().fromJson(reqEventDetail, DetailEventResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showDetail(detailEvent?.detailItems, homeEvent?.teamsItems, awayEvent?.teamsItems)
            }

        }

    }

}