package com.example.rickandmorty.ui.locations

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.Repository

class LocationsViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val locations = repository.getLocations()
}