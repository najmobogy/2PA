package com.example.fitnesstracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val activityList = mutableListOf<Activity>()
    private lateinit var adapter: ActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.activity_recycler_view)
        adapter = ActivityAdapter(activityList) { activity ->
            showActivityDetails(activity)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Dodawanie aktywności
        findViewById<Button>(R.id.add_activity_button).setOnClickListener {
            addActivity()
        }


    fun addActivity() {
        val type = when (findViewById<RadioGroup>(R.id.activity_type_group).checkedRadioButtonId) {
            R.id.type_walk -> "Spacer"
            R.id.type_run -> "Bieg"
            else -> "Trening siłowy"
        }

        val distance = findViewById<EditText>(R.id.distance_input).text.toString().toDoubleOrNull() ?: 0.0
        val duration = findViewById<EditText>(R.id.duration_input).text.toString().toIntOrNull() ?: 0
        val calories = findViewById<EditText>(R.id.calories_input).text.toString().toIntOrNull() ?: 0
        val intensity = when (findViewById<SeekBar>(R.id.intensity_seekbar).progress) {
            in 0..3 -> "Niska"
            in 4..7 -> "Średnia"
            else -> "Wysoka"
        }

        val activity = Activity(type, distance, duration, calories, intensity)
        activityList.add(activity)
        adapter.notifyItemInserted(activityList.size - 1)
    }


    fun showActivityDetails(activity: Activity) {
        AlertDialog.Builder(this)
            .setTitle(activity.type)
            .setMessage("Dystans: ${activity.distance} km\nCzas: ${activity.duration} min\nKalorie: ${activity.calories}\nIntensywność: ${activity.intensity}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}

    private fun addActivity() {
        TODO("Not yet implemented")
    }

    private fun showActivityDetails(activity: Activity) {

    }}
