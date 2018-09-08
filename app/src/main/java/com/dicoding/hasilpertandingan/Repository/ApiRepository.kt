package com.dicoding.hasilpertandingan.Repository

import com.dicoding.hasilpertandingan.BuildConfig
import java.net.URL

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }

    fun reqEvent(teamId: String?): String {
        return URL(BuildConfig.TEAM_EVENT + teamId).readText()
    }

    fun reqDetail(matchId: String?): String {
        return URL(BuildConfig.DETAIL_EVENT + matchId).readText()
    }

}