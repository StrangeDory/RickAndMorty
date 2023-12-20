package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.entities.CharacterList
import com.example.rickandmorty.data.entities.Location
import com.example.rickandmorty.data.entities.LocationList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("character")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    @GET("location")
    suspend fun getAllLocations() : Response<LocationList>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>
}