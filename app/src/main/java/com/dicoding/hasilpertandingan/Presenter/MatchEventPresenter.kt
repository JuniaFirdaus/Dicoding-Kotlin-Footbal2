package com.dicoding.hasilpertandingan.Presenter

import com.dicoding.hasilpertandingan.Repository.TheSportDB
import com.dicoding.hasilpertandingan.Repository.ApiRepository
import com.dicoding.hasilpertandingan.Views.MatchEventView
import com.dicoding.hasilpertandingan.Model.MatchEventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
class MatchEventPresenter(
        private val eventView: MatchEventView,
        private val apiRepository: ApiRepository,
        private val gson: Gson) {

    fun getMatch(nextOrMatch: String?) {

        eventView.showLoading()

        when(nextOrMatch) {
            "NEXT_EVENT" -> {
                doAsync {
                    val data = gson.fromJson(apiRepository
                            .doRequest(TheSportDB.getNextMatch()),
                            MatchEventResponse::class.java
                    )
                    uiThread {
                        eventView.hideLoading()
                        eventView.showMatch(data.matchItems)
                        if(data.matchItems?.size == null) {
                            eventView.showNull()
                        }
                    }
                }

            }
            "LAST_EVENT" -> {
                doAsync {
                    val data = gson.fromJson(apiRepository
                            .doRequest(TheSportDB.getLastMatch()),
                            MatchEventResponse::class.java
                    )
                    uiThread {
                        eventView.hideLoading()
                        eventView.showMatch(data.matchItems)
                        if (data.matchItems?.size == null) {
                            eventView.showNull()
                        }
                    }
                }
            }
        }


    }

}