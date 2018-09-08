package com.dicoding.hasilpertandingan.Repository

import com.dicoding.hasilpertandingan.BuildConfig

/**
 * Created by ${JUNIA} on 9/2/2018.
 */

object TheSportDB {

    fun getNextMatch(): String {
        return BuildConfig.NEXT_EVENT
    }

    fun getLastMatch(): String {
        return BuildConfig.LAST_EVENT
    }
}