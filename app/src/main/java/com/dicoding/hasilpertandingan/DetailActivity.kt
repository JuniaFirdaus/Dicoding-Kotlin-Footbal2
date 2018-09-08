package com.dicoding.hasilpertandingan

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.dicoding.hasilpertandingan.Presenter.DetailEventPresenter
import com.dicoding.hasilpertandingan.Views.DetailView
import com.google.gson.Gson
import com.dicoding.hasilpertandingan.Model.DetailEvent
import com.dicoding.hasilpertandingan.Model.TeamEvent
import com.dicoding.hasilpertandingan.Repository.ApiRepository
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
/**
 * Created by ${JUNIA} on 9/2/2018.
 */
class DetailActivity : AppCompatActivity(), DetailView {

    private val detailItems: MutableList<DetailEvent> = mutableListOf()
    private lateinit var detailEventPresenter: DetailEventPresenter

    override fun showLoading() {
        prograss.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        prograss.visibility = View.INVISIBLE
    }

    override fun showDetail(detail: List<DetailEvent>?, home: List<TeamEvent>?, away: List<TeamEvent>?) {
        try {
            let {
                val data = detail?.get(0)
                val homeData = home?.get(0)
                val awayData = away?.get(0)

                val goalHome: String? = data?.strHomeGoalDetails
                goalHome?.replace(";", "\n")
                val redHome: String? = data?.strHomeRedCards
                redHome?.replace(";", "\n")
                val yellowHome: String? = data?.strHomeYellowCards
                yellowHome?.replace(";", "\n")
                val gkHome: String? = data?.strHomeLineupGoalkeeper
                gkHome?.replace(";", "\n")
                val defHome: String? = data?.strHomeLineupDefense
                defHome?.replace(";", "\n")
                val midHome: String? = data?.strHomeLineupMidfield
                midHome?.replace(";", "\n")
                val forHome: String? = data?.strHomeLineupForward
                forHome?.replace(";", "\n")
                val subHome: String? = data?.strHomeLineupSubstitutes
                subHome?.replace(";", "\n")

                val goalAway: String? = data?.strAwayGoalDetails
                goalAway?.replace(";", "\n")
                val redAway: String? = data?.strAwayRedCards
                redAway?.replace(";", "\n")
                val yellowAway: String? = data?.strAwayYellowCards
                yellowAway?.replace(";", "\n")
                val gkAway: String? = data?.strAwayLineupGoalkeeper
                gkAway?.replace(";", "\n")
                val defAway: String? = data?.strAwayLineupDefense
                defAway?.replace(";", "\n")
                val midAway: String? = data?.strAwayLineupMidfield
                midAway?.replace(";", "\n")
                val forAway: String? = data?.strAwayLineupForward
                forAway?.replace(";", "\n")
                val subAway: String? = data?.strAwayLineupSubstitutes
                subAway?.replace(";", "\n")

                Glide.with(ctx).load(homeData?.strTeamBadge).into(logo_home)
                txt_couch.text = homeData?.strManager
                txt_goal_home.text = goalHome
                txt_shots_home.text = data?.intHomeShots
                txt_red_home.text = redHome
                txt_yellow_home.text = yellowHome
                txt_gk_home.text = gkHome
                txt_def_home.text = defHome
                txt_mid_home.text = midHome
                txt_for_home.text = forHome
                txt_sub_home.text = subHome

                Glide.with(ctx).load(awayData?.strTeamBadge).into(logo_away)
                txt_couch_away.text = awayData?.strManager
                txt_goal_away.text = goalAway
                txt_shots_away.text = data?.intAwayShots
                txt_red_away.text = redAway
                txt_yellow_away.text = yellowAway
                txt_gk_away.text = gkAway
                txt_def_away.text = defAway
                txt_mid_away.text = midAway
                txt_for_away.text = forAway
                txt_sub_away.text = subAway
            }
        } catch (e: Exception) {
            Log.d("TAG", e.toString())
        }
    }

    override fun showBadge() {
        Log.i("Away Badge", "${detailItems[0].strAwayGoalDetails}")
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ctx.let {
            val i = intent

            detailEventPresenter = DetailEventPresenter(this, ApiRepository(), Gson())

            txt_date.text = i.getStringExtra("dateMatch")
            txt_home.text = i.getStringExtra("homeTeam")
            txt_team_away.text = i.getStringExtra("awayTeam")
            txt_score.text = i.getStringExtra("goalHome") + ":" + i.getStringExtra("goalAway")

            val homeId: String? = i.getStringExtra("idHome")
            val awayId: String? = i.getStringExtra("idAway")
            val matchId: String? = i.getStringExtra("matchId")

            detailEventPresenter.loadDetailMatch(homeId, awayId, matchId)

        }

    }
}
