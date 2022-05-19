package com.daltonapps.calculatemypace.modules.log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daltonapps.calculatemypace.calculatemypace.R
import com.daltonapps.calculatemypace.models.Run
import java.util.ArrayList

class LogsAdapter(private val runs: ArrayList<Run>) : RecyclerView.Adapter<LogsAdapter.LogsViewHolder>() {

    class LogsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.activity_date)
//        val pace: TextView = view.findViewById(R.id.activity_pace)
        val time: TextView = view.findViewById(R.id.activity_time)
        val distance: TextView = view.findViewById(R.id.activity_distance)

        val avgHeartRate: TextView = view.findViewById(R.id.activity_avg_heart_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent, false)

        return LogsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val run = runs[position]
        holder.date.text = run.date
//        holder.pace.text = (run.duration / 1000).toString() + "s"
        holder.time.text = "Time: " + (run.time / 1000).toString() + "s"
        holder.distance.text = "Distance: " + run.distance
    }

    override fun getItemCount() = runs.size
}