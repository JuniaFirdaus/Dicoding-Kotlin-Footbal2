package com.dicoding.hasilpertandingan

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.hasilpertandingan.R.id.next_match
import com.dicoding.hasilpertandingan.R.id.past_match
import com.dicoding.hasilpertandingan.Fragment.NextEvent
import com.dicoding.hasilpertandingan.Fragment.LastEvent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by ${JUNIA} on 9/2/2018.
 */
@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener ({ item ->
            when(item.itemId) {
                past_match -> {
                    loadPastMatch(savedInstanceState)
                }
                next_match -> {
                    loadNextMatch(savedInstanceState)
                }
            }
            true
        })
        bottom_navigation.selectedItemId = past_match
    }

    private fun loadPastMatch(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, LastEvent(), LastEvent::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadNextMatch(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, NextEvent(), NextEvent::class.simpleName)
                    .commit()
        }
    }
}
