package com.example.rickandmorty.ui.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.Repository

class CharactersViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val characters = repository.getCharacters()
}
