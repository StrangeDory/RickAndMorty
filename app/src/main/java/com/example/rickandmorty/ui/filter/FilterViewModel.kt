package com.example.rickandmorty.ui.filter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.repository.Repository
import com.example.rickandmorty.utils.Resource
import kotlinx.coroutines.launch

class FilterViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    var listCharactersInEpisode = MutableLiveData<List<Character>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()
    var characters: LiveData<Resource<List<Character>>>? = null

    fun getCharacters(){
        characters = repository.getCharacters()
        isFilter.value = true
    }

    fun getByName(name: String){
        characters = repository.getCharactersByName(name)
    }

    fun getByStatusAndGender(status : String, gender: String){
        viewModelScope.launch{
            val characters = repository.getCharactersByStatusAndGender(status, gender)
            listCharactersInEpisode.value = characters.value?.data
            isFilter.value = true
        }
    }

    fun getByStatus(status : String){
        viewModelScope.launch{
            val characters = repository.getCharactersByStatus(status)
            listCharactersInEpisode.value = characters.value?.data
            isFilter.value = true
        }
    }

    fun getByGender(gender: String){
        characters = repository.getCharactersByGender(gender)
        isFilter.value = true
    }
}