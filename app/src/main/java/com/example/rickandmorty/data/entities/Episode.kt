package com.example.rickandmorty.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class Episode (
    @PrimaryKey
    val id: Int,
    val name: String,
    val air_date: String?,
    val episode: String,
    val url: String,
    val created: String
)