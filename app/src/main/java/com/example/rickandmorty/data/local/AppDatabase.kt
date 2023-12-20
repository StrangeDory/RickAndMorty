package com.example.rickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.data.entities.Location

@Database(entities = [Character::class, Location::class, Episode::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun Dao(): Dao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "RickAndMorty")
                .fallbackToDestructiveMigration()
                .build()
    }

}