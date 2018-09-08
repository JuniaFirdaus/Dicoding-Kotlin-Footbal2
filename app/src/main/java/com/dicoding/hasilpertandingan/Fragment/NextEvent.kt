package com.dicoding.hasilpertandingan.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.dicoding.hasilpertandingan.DetailActivity
import com.dicoding.hasilpertandingan.R
import com.dicoding.hasilpertandingan.Model.MatchEvent
import com.dicoding.hasilpertandingan.Repository.ApiRepository
import com.dicoding.hasilpertandingan.MainAdapter
import com.dicoding.hasilpertandingan.Presenter.MatchEventPresenter
import com.dicoding.hasilpertandingan.Views.MatchEventView
import com.google.gson.Gson

import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 */
class NextEvent : Fragment(), MatchEventView {

    private val matchItems: MutableList<MatchEvent> = mutableListOf()
    private lateinit var matchEventPresenter: MatchEventPresenter
    private lateinit var mainAdapter: MainAdapter

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val nextMatch: String = "NEXT_EVENT"

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showMatch(data: List<MatchEvent>?) {
        data?.let {
            Log.i("On Show Match : ", "Data Size : ${data?.size}")
            mainAdapter.refresh(it)
        }
    }

    override fun showNull() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val views = inflater?.inflate(R.layout.fragment_next_match, container, false)

        progressBar = views?.findViewById(R.id.prograss) as ProgressBar
        recyclerView = views?.findViewById(R.id.rcv_next) as RecyclerView

        views?.let {

            mainAdapter = MainAdapter(context, matchItems) {
                ctx.startActivity<DetailActivity>(
                        "idHome" to it.idHomeTeam, "idAway" to it.idAwayTeam,
                        "goalHome" to it.intHomeScore, "goalAway" to it.intAwayScore,
                        "homeTeam" to it.strHomeTeam, "awayTeam" to it.strAwayTeam,
                        "dateMatch" to it.strDate,
                        "matchId" to it.idEvent
                )
            }

            recyclerView.layoutManager = LinearLayoutManager(ctx)
            recyclerView.adapter = mainAdapter
            matchEventPresenter = MatchEventPresenter(this, ApiRepository(), Gson())
            matchEventPresenter.getMatch(nextMatch)

        }

        return views
    }

}