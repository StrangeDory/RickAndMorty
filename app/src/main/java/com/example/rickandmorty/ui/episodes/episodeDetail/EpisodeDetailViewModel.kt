package com.example.rickandmorty.ui.episodes.episodeDetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.data.repository.Repository
import com.example.rickandmorty.utils.Resource

class EpisodeDetailViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _episode = _id.switchMap { id ->
        repository.getEpisode(id)
    }
    val episode: LiveData<Resource<Episode>> = _episode


    fun start(id: Int) {
        _id.value = id
    }

}
