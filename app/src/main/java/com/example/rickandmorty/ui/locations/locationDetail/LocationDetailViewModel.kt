package com.example.rickandmorty.ui.locations.locationDetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.rickandmorty.data.entities.Location
import com.example.rickandmorty.data.repository.Repository
import com.example.rickandmorty.utils.Resource

class LocationDetailViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _location = _id.switchMap { id ->
        repository.getLocation(id)
    }
    val location: LiveData<Resource<Location>> = _location


    fun start(id: Int) {
        _id.value = id
    }

}
