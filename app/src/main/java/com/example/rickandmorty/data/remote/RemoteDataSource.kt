package com.example.rickandmorty.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: Service
): BaseDataSource() {

    suspend fun getCharacters() = getResult { service.getAllCharacters() }
    suspend fun getCharacter(id: Int) = getResult { service.getCharacter(id) }
    suspend fun getCharactersByName(name: String) = getResult { service.getCharactersByName(name) }
    suspend fun getCharactersByStatusAndGender(status : String, gender: String) = getResult { service.getCharactersByStatusAndGender(status, gender) }
    suspend fun getCharactersByStatus(status : String) = getResult { service.getCharactersByStatus(status) }
    suspend fun getCharactersByGender(gender: String) = getResult { service.getCharactersByGender(gender) }
    suspend fun getLocations() = getResult { service.getAllLocations() }
    suspend fun getLocation(id: Int) = getResult { service.getLocation(id) }
    suspend fun getEpisodes() = getResult { service.getAllEpisodes() }
    suspend fun getEpisode(id: Int) = getResult { service.getEpisode(id) }
}