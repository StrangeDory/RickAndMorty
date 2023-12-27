package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.CharacterList
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.data.entities.EpisodeList
import com.example.rickandmorty.data.entities.Location
import com.example.rickandmorty.data.entities.LocationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("character/?name=Rick")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    @GET("character/?name={name}")
    suspend fun getCharactersByName(@Path("name") name : String): Response<CharacterList>

    @GET("character")
    suspend fun getCharactersByStatusAndGender(@Query("status") status : String,
                                               @Query("gender") gender : String): Response<CharacterList>

    @GET("character")
    suspend fun getCharactersByStatus(@Query("status") status : String): Response<CharacterList>

    @GET("character/{gender}")
    suspend fun getCharactersByGender(@Path("gender") gender : String): Response<CharacterList>

    @GET("location")
    suspend fun getAllLocations() : Response<LocationList>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>

    @GET("episode")
    suspend fun getAllEpisodes() : Response<EpisodeList>

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Episode>
}