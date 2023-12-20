package com.example.rickandmorty.ui.locations

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.CharacterRepository

class LocationsViewModel @ViewModelInject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val locations = repository.getLocations()
}