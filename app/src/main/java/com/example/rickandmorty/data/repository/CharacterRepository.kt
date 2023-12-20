package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.local.Dao
import com.example.rickandmorty.data.remote.RemoteDataSource
import com.example.rickandmorty.utils.performGetOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: Dao
) {

    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = { localDataSource.insertCharacter(it) }
    )

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAllCharacters(it.results) }
    )

    fun getLocation(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getLocation(id) },
        networkCall = { remoteDataSource.getLocation(id) },
        saveCallResult = { localDataSource.insertLocation(it) }
    )

    fun getLocations() = performGetOperation(
        databaseQuery = { localDataSource.getAllLocations() },
        networkCall = { remoteDataSource.getLocations() },
        saveCallResult = { localDataSource.insertAllLocations(it.results) }
    )
}