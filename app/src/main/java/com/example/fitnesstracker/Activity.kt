package com.example.fitnesstracker

data class Activity(
    val type: String, // Spacer, Bieg, Trening siłowy
    var distance: Double, // w kilometrach
    var duration: Int, // w minutach
    var calories: Int, // spalone kalorie
    var intensity: String // Niska, Średnia, Wysoka
)

