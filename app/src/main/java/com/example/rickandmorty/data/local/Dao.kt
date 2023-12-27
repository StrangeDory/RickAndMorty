package com.example.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.data.entities.Location

@Dao
interface Dao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacter(id: Int): LiveData<Character>

    @Query("SELECT * FROM characters WHERE name = :characterName")
    fun getCharactersByName(characterName: String) : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE status = :status AND gender = :gender")
    fun getCharactersByStatusAndGender(status : String, gender: String) : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE status = :status")
    fun getCharactersByStatus(status : String) : LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE gender = :gender")
    fun getCharactersByGender(gender: String) : LiveData<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCharacters(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: Character)

    @Query("SELECT * FROM locations")
    fun getAllLocations() : LiveData<List<Location>>

    @Query("SELECT * FROM locations WHERE id = :id")
    fun getLocation(id: Int): LiveData<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLocations(locations: List<Location>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(location: Location)

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes() : LiveData<List<Episode>>

    @Query("SELECT * FROM episodes WHERE id = :id")
    fun getEpisode(id: Int): LiveData<Episode>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEpisodes(episodes: List<Episode>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(episode: Episode)
}