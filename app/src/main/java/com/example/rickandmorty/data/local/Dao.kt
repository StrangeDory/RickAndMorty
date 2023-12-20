package com.example.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.Location

@Dao
interface Dao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id: Int): LiveData<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character)

    @Query("SELECT * FROM locations")
    fun getAllLocations() : LiveData<List<Location>>

    @Query("SELECT * FROM locations WHERE id = :id")
    fun getLocation(id: Int): LiveData<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocations(locations: List<Location>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)
}