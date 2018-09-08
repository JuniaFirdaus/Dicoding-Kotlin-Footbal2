package com.dicoding.hasilpertandingan

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dicoding.hasilpertandingan.Model.MatchEvent
import org.jetbrains.anko.sdk25.coroutines.onClick
/**
 * Created by ${JUNIA} on 9/2/2018.
 */

class MainAdapter(private val context: Context?, private var matchItems: List<MatchEvent>, private val listener: (MatchEvent) -> Unit)
    : RecyclerView.Adapter<MainAdapter.MatchViewHolder>(){


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(matchItems[position], listener)
    }

    override fun getItemCount(): Int {
        return matchItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main_design, parent, false))
    }

    fun refresh(fill: List<MatchEvent>) {
        matchItems = fill
        notifyDataSetChanged()
    }

    class MatchViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val dateMatch = view.findViewById(R.id.txt_date) as TextView
        private val homeTeam = view.findViewById(R.id.txt_home) as TextView
        private val awayTeam = view.findViewById(R.id.txt_away) as TextView
        private val scoreTeam = view.findViewById(R.id.txt_score) as TextView

        fun bindItem(matchEvent: MatchEvent, listener: (MatchEvent) -> Unit) {

            dateMatch.text = matchEvent.strDate
            homeTeam.text = matchEvent.strHomeTeam
            awayTeam.text = matchEvent.strAwayTeam
            scoreTeam.text = matchEvent.intHomeScore + ":" + matchEvent.intAwayScore
            itemView.onClick {listener(matchEvent)}

        }

    }


}