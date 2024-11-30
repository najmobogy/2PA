package com.example.fitnesstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter(
    private val activityList: MutableList<Activity>,
    private val clickListener: (Activity) -> Unit
) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val type: TextView = itemView.findViewById(R.id.activity_type)
        val details: TextView = itemView.findViewById(R.id.activity_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activityList[position]
        holder.type.text = activity.type
        holder.details.text = "Dystans: ${activity.distance} km, Czas: ${activity.duration} min, Kalorie: ${activity.calories}, Intensywność: ${activity.intensity}"

        holder.itemView.setOnClickListener {
            clickListener(activity)
        }
    }

    override fun getItemCount(): Int = activityList.size
}