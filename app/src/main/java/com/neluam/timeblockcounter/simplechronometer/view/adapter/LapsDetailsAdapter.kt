package com.neluam.timeblockcounter.simplechronometer.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neluam.timeblockcounter.R
import com.neluam.timeblockcounter.simplechronometer.model.LapModel

class LapsDetailsAdapter: RecyclerView.Adapter<LapsDetailsAdapter.ViewHolder>() {

    var lapsItemsDetails: List<LapModel> = ArrayList()

    @SuppressLint("NotConstructor")
    fun LapsDetailsAdapter(laps: List<LapModel>) {
        this.lapsItemsDetails = laps
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val idLapView = view.findViewById(R.id.idLap) as TextView
        val timeLapView = view.findViewById(R.id.timeLap) as TextView

        fun bind(lap: LapModel) {
            idLapView.text = lap.id.toString()
            timeLapView.text = lap.time
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_lap_detail, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
        lapsItemsDetails.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val lap = lapsItemsDetails[position]
        viewHolder.bind(lap)
    }

}