package com.example.rickandmorty.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: Service
): BaseDataSource() {

    suspend fun getCharacters() = getResult { service.getAllCharacters() }
    suspend fun getCharacter(id: Int) = getResult { service.getCharacter(id) }
    suspend fun getLocations() = getResult { service.getAllLocations() }
    suspend fun getLocation(id: Int) = getResult { service.getLocation(id) }
}