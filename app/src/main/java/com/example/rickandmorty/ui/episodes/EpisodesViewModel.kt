package com.example.rickandmorty.ui.episodes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.Repository

class EpisodesViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val episodes = repository.getEpisodes()
}